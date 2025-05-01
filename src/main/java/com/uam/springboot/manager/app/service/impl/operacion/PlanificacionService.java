package com.uam.springboot.manager.app.service.impl.operacion;

import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.AmbienteResponseDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.BloqueHorarioResponseDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.GrupoResponseDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.ExcepcionReservaResponseDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.PlantillaReservaResponseDTO;
import com.uam.springboot.manager.app.mapper.catalogos.AmbienteMapper;
import com.uam.springboot.manager.app.mapper.catalogos.BloqueHorarioMapper;
import com.uam.springboot.manager.app.mapper.catalogos.GrupoMapper;
import com.uam.springboot.manager.app.model.catalogos.DIASSEMANA;
import com.uam.springboot.manager.app.model.operacion.TIPOEXCEPCION;
import com.uam.springboot.manager.app.service.impl.operacion.ExcepcionReservaService;
import com.uam.springboot.manager.app.service.impl.operacion.PlantillaReservaService;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlanificacionService {

    private final PlantillaReservaService plantillaService;
    private final ExcepcionReservaService excepcionService;
    private final AmbienteMapper ambienteMapper;
    private final BloqueHorarioMapper bloqueHorarioMapper;
    private final GrupoMapper grupoMapper;

    public PlanificacionService(
            PlantillaReservaService plantillaService,
            ExcepcionReservaService excepcionService,
            AmbienteMapper ambienteMapper,
            BloqueHorarioMapper bloqueHorarioMapper,
            GrupoMapper grupoMapper) {
        this.plantillaService = plantillaService;
        this.excepcionService = excepcionService;
        this.ambienteMapper = ambienteMapper;
        this.bloqueHorarioMapper = bloqueHorarioMapper;
        this.grupoMapper = grupoMapper;
    }

    /**
     * Genera la planificación de reservas para una fecha concreta,
     * combinando plantillas semanales y excepciones definidas.
     */
    public List<PlantillaReservaResponseDTO> getPlanificacionParaFecha(
            Long periodoId,
            LocalDate fecha) {
        // 1) Mapear fecha -> DIASSEMANA
        DIASSEMANA dia = DIASSEMANA.fromDayOfWeek(fecha.getDayOfWeek());

        // 2) Obtener plantillas base y excepciones
        List<PlantillaReservaResponseDTO> plantillas =
                plantillaService.findByPeriodoAndDia(periodoId, dia);

        List<ExcepcionReservaResponseDTO> excepciones =
                excepcionService.findByFecha(fecha);

        // 3) Indexar excepciones por ID de plantilla
        Map<Long, ExcepcionReservaResponseDTO> exMap = excepciones.stream()
                .collect(Collectors.toMap(
                        er -> er.plantilla().id(),
                        er -> er
                ));

        // 4) Combinar plantillas y excepciones
        List<PlantillaReservaResponseDTO> resultado = new ArrayList<>();
        for (PlantillaReservaResponseDTO pr : plantillas) {
            ExcepcionReservaResponseDTO ex = exMap.get(pr.id());

            // Excepción de anulación: omitir reserva
            if (ex != null && ex.tipo() == TIPOEXCEPCION.ANULACION) {
                continue;
            }

            // Excepción de modificación: crear un DTO modificado
            if (ex != null && ex.tipo() == TIPOEXCEPCION.MODIFICACION) {
                AmbienteResponseDTO ambienteDTO = ex.nuevoAmbiente() != null
                        ? ambienteMapper.toDto(ex.nuevoAmbiente())
                        : pr.ambiente();

                BloqueHorarioResponseDTO timeSlotDTO = ex.nuevoTimeSlot() != null
                        ? bloqueHorarioMapper.toDto(ex.nuevoTimeSlot())
                        : pr.timeSlot();

                GrupoResponseDTO grupoDTO = ex.grupo() != null
                        ? grupoMapper.toDto(ex.grupo())
                        : pr.grupo();

                resultado.add(new PlantillaReservaResponseDTO(
                        pr.id(),
                        pr.periodo(),
                        pr.diaSemana(),
                        ambienteDTO,
                        timeSlotDTO,
                        grupoDTO
                ));
            } else {
                // Sin excepción, se conserva la plantilla original
                resultado.add(pr);
            }
        }

        return resultado;
    }
}
