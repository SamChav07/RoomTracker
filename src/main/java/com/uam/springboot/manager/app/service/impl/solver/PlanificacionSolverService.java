package com.uam.springboot.manager.app.service.impl.solver;

import com.uam.springboot.manager.app.dto.operacion.requestDTOs.PlantillaReservaRequestDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.PlantillaReservaResponseDTO;
import com.uam.springboot.manager.app.dto.solver.*;
import com.uam.springboot.manager.app.model.catalogos.*;
import com.uam.springboot.manager.app.model.solicitud.ESTADOSOLICITUD;
import com.uam.springboot.manager.app.model.solicitud.Solicitud;
import com.uam.springboot.manager.app.model.solicitud.SolicitudItem;
import com.uam.springboot.manager.app.model.solver.PlanificacionDiariaSolver;
import com.uam.springboot.manager.app.model.solver.ReservaTentativa;
import com.uam.springboot.manager.app.repository.catalogos.AmbienteRepository;
import com.uam.springboot.manager.app.repository.catalogos.BloqueHorarioRepository;
import com.uam.springboot.manager.app.repository.catalogos.GrupoRepository;
import com.uam.springboot.manager.app.repository.catalogos.PeriodoAcademicoRepository;
import com.uam.springboot.manager.app.repository.solicitud.SolicitudItemRepository;
import com.uam.springboot.manager.app.repository.solicitud.SolicitudRepository;
import com.uam.springboot.manager.app.service.impl.operacion.PlantillaReservaService;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.optaplanner.core.api.score.ScoreExplanation;
import org.optaplanner.core.api.score.ScoreManager;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.constraint.Indictment;
import org.optaplanner.core.api.score.director.ScoreDirector;
import org.optaplanner.core.api.solver.*;
import org.optaplanner.core.impl.score.director.ScoreDirectorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.api.solver.SolverJob;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class PlanificacionSolverService {

    private final AtomicLong reservaIdCounter = new AtomicLong(1);

    @Autowired
    private SolicitudItemRepository solicitudItemRepo;
    @Autowired private AmbienteRepository ambienteRepo;
    @Autowired private BloqueHorarioRepository bloqueRepo;
    @Autowired private PeriodoAcademicoRepository periodoRepo;
    @Autowired private SolverManager<PlanificacionDiariaSolver, Long> solverManager;
    @Autowired private SolicitudRepository solicitudRepo;
    @Autowired
    private SolverFactory<PlanificacionDiariaSolver> solverFactory;
    @Autowired private  PlantillaReservaService plantillaService;
    @Autowired private ReservaToPlantillaMapper reservaMapper;

    private ScoreManager<PlanificacionDiariaSolver, HardSoftScore> scoreManager;

    @PostConstruct
    public void init() {
        scoreManager = ScoreManager.create(solverFactory);
    }

    /**
     * Ejecuta el solver para un periodo + fecha, devolviendo asignadas y rechazadas.
     */
    public PlanificacionResultadoDTO planificarDia(Long periodoAcademicoId, LocalDate fecha) {
        // 1. Obtener solicitudes en proceso
        List<Solicitud> solicitudesEnProceso =
                solicitudRepo.findAllByEstado(ESTADOSOLICITUD.EN_PROCESO);


        System.out.println("Solicitudes: " + solicitudesEnProceso.size());

        // 2. Aplanar en items y ordenar por fechaSolicitud ascendente
        List<SolicitudItem> itemsEnProceso = solicitudesEnProceso.stream()
                .flatMap(s -> s.getItems().stream()
                        // solo los que incluyen el día buscado
                        .filter(item -> item.getDiasSemana().contains(toDiaSemana(fecha))))
                .sorted(Comparator.comparing(item -> item.getSolicitud().getFechaSolicitud()))
                .collect(Collectors.toList());

        System.out.println("Solicitudes item: " + itemsEnProceso.size());

        // 3. Convertir en ReservaTentativa, asignando priority incremental
        List<ReservaTentativa> tentativas = new ArrayList<>();
        AtomicInteger prioCounter = new AtomicInteger(1);
        for (SolicitudItem item : itemsEnProceso) {
            int priority = prioCounter.getAndIncrement();
            for (int i = 0; i < item.getNumeroGrupos(); i++) {
                long uniqueId = reservaIdCounter.getAndIncrement();
                tentativas.add(new ReservaTentativa(
                        uniqueId,
                        item.getGrupo(),
                        toDiaSemana(fecha),
                        item.getBloqueInicio(),
                        item.getDuracionBloques(),
                        priority));
            }
        }

        System.out.println("Tentativas antes de solver: " + tentativas.size());


        // 4. Cargar facts
        List<Ambiente> ambientes = ambienteRepo.findAllByEstado(ESTADOAMBIENTE.ACTIVO);
        List<BloqueHorario> bloques = bloqueRepo.findAll();

        // 5. Construir solución inicial
        PlanificacionDiariaSolver problem = new PlanificacionDiariaSolver(
                ambientes, bloques, tentativas);

        // 6. Lanzar el solver y bloquear hasta obtener la solución final
        Long problemId = System.currentTimeMillis();
        SolverJob<PlanificacionDiariaSolver, Long> solverJob =
                solverManager.solve(problemId, problem);
        PlanificacionDiariaSolver solution;
        try {
            solution = solverJob.getFinalBestSolution();  // bloquea hasta terminar

        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Solver interrumpido", e);
        }

        ScoreExplanation<PlanificacionDiariaSolver, HardSoftScore> scoreExplanation =
                scoreManager.explainScore(solution);
        Map<Object, Indictment<HardSoftScore>> indictmentMap =
                scoreExplanation.getIndictmentMap();

        // 7. Mapear resultados
        List<ReservaDTO> asignadas = solution.getReservas().stream()
                .filter(r -> r.getAmbiente() != null && r.getBloqueInicio() != null)
                .map(r -> new ReservaDTO(
                        r.getGrupo().getCodigo(),
                        r.getGrupo().getAsignatura().getNombre(),
                        r.getDiaSemana(),
                        r.getDuracionBloques(),
                        r.getAmbiente().getCodigo(),
                        r.getBloqueInicio().getIndice()
                ))
                .collect(Collectors.toList());

        List<ReservaRechazadaDTO> rechazadas = solution.getReservas().stream()
                .filter(r -> r.getAmbiente() == null || r.getBloqueInicio() == null)
                .map(r -> new ReservaRechazadaDTO(
                        r.getGrupo().getCodigo(),
                        r.getGrupo().getAsignatura().getNombre(),
                        r.getDiaSemana(),
                        r.getDuracionBloques(),
                        obtenerMotivo(r, indictmentMap)
                ))
                .toList();

        System.out.println("Reservas en solución: " + solution.getReservas().size());

        System.out.println("Asignadas: " + asignadas.size());



        return new PlanificacionResultadoDTO(asignadas, rechazadas);
    }

    public PlanificacionRangoDTO planificarRango(Long periodoId,
                                                 LocalDate desde,
                                                 LocalDate hasta) {
        if (hasta.isBefore(desde)) {
            throw new IllegalArgumentException("La fecha final debe ser ≥ la inicial");
        }
        List<PlanificacionDiaDTO> resultado = new ArrayList<>();
        LocalDate fecha = desde;
        while (!fecha.isAfter(hasta)) {
            PlanificacionResultadoDTO dia = planificarDia(periodoId, fecha);
            resultado.add(new PlanificacionDiaDTO(fecha,
                    dia.getAsignadas(),
                    dia.getRechazadas()));
            fecha = fecha.plusDays(1);
        }
        return new PlanificacionRangoDTO(resultado);
    }

    @Transactional
    public List<PlantillaReservaResponseDTO> planificarYRellenarPlantillas(
            Long periodoId, LocalDate desde, LocalDate hasta) {

        PlanificacionRangoDTO rango = planificarRango(periodoId, desde, hasta);
        List<PlantillaReservaResponseDTO> creadas = new ArrayList<>();

        for (PlanificacionDiaDTO dia : rango.getDias()) {
            for (ReservaDTO r : dia.getAsignadas()) {

                // Traducir el DTO en 1-N requests
                List<PlantillaReservaRequestDTO> requests =
                        reservaMapper.toPlantillaRequests(periodoId, r);

                // Guardar en lote (mejor rendimiento)
                List<PlantillaReservaResponseDTO> batch =
                        plantillaService.createBatch(requests);

                creadas.addAll(batch);
            }
        }
        return creadas;
    }


    private DIASSEMANA toDiaSemana(LocalDate fecha) {
        return DIASSEMANA.fromDayOfWeek(fecha.getDayOfWeek());
    }
    private static String obtenerMotivo(ReservaTentativa r,
                                        Map<Object, Indictment<HardSoftScore>> indictments) {
        Indictment<HardSoftScore> ind = indictments.get(r);
        if (ind == null || ind.getConstraintMatchSet().isEmpty()) {
            return "Sin espacio disponible";
        }
        // Nos quedamos con el primer constraint violado (o los unes con “; ” si prefieres)
        return ind.getConstraintMatchSet()
                .iterator().next()
                .getConstraintName();
    }
}



