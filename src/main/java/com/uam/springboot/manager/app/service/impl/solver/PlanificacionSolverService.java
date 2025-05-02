package com.uam.springboot.manager.app.service.impl.solver;

import com.uam.springboot.manager.app.dto.solver.PlanificacionResultadoDTO;
import com.uam.springboot.manager.app.dto.solver.ReservaDTO;
import com.uam.springboot.manager.app.model.catalogos.Ambiente;
import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import com.uam.springboot.manager.app.model.catalogos.DIASSEMANA;
import com.uam.springboot.manager.app.model.catalogos.ESTADOAMBIENTE;
import com.uam.springboot.manager.app.model.solicitud.ESTADOSOLICITUD;
import com.uam.springboot.manager.app.model.solicitud.Solicitud;
import com.uam.springboot.manager.app.model.solicitud.SolicitudItem;
import com.uam.springboot.manager.app.model.solver.PlanificacionDiariaSolver;
import com.uam.springboot.manager.app.model.solver.ReservaTentativa;
import com.uam.springboot.manager.app.repository.catalogos.AmbienteRepository;
import com.uam.springboot.manager.app.repository.catalogos.BloqueHorarioRepository;
import com.uam.springboot.manager.app.repository.catalogos.PeriodoAcademicoRepository;
import com.uam.springboot.manager.app.repository.solicitud.SolicitudItemRepository;
import com.uam.springboot.manager.app.repository.solicitud.SolicitudRepository;
import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
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

        List<ReservaDTO> rechazadas = solution.getReservas().stream()
                .filter(r -> r.getAmbiente() == null || r.getBloqueInicio() == null)
                .map(r -> new ReservaDTO(
                        r.getGrupo().getCodigo(),
                        r.getGrupo().getAsignatura().getNombre(),
                        r.getDiaSemana(),
                        r.getDuracionBloques(),
                        null,
                        null
                ))
                .collect(Collectors.toList());

        System.out.println("Reservas en solución: " + solution.getReservas().size());

        System.out.println("Asignadas: " + asignadas.size());



        return new PlanificacionResultadoDTO(asignadas, rechazadas);
    }

    private DIASSEMANA toDiaSemana(LocalDate fecha) {
        return DIASSEMANA.fromDayOfWeek(fecha.getDayOfWeek());
    }
}

