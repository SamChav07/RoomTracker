package com.uam.springboot.manager.app.controller.operacion;

import com.uam.springboot.manager.app.dto.operacion.responseDTOs.PlantillaReservaResponseDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.SimplePlantillaReservaResponseDTO;
import com.uam.springboot.manager.app.service.impl.operacion.PlanificacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/planificacion")
public class PlanificacionController {

    private final PlanificacionService service;

    public PlanificacionController(PlanificacionService service) {
        this.service = service;
    }

    @GetMapping("/periodo/{periodoId}/fecha/{fecha}")
    public ResponseEntity<List<PlantillaReservaResponseDTO>> getPlanificacion(
            @PathVariable Long periodoId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ResponseEntity.ok(service.getPlanificacionParaFecha(periodoId, fecha));
    }

    @GetMapping("/periodo/{periodoId}/fecha/{fecha}/simple")
    public ResponseEntity<List<SimplePlantillaReservaResponseDTO>> getPlanificacionSimple(
            @PathVariable Long periodoId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ResponseEntity.ok(
                service.getPlanificacionSimpleParaFecha(periodoId, fecha)
        );
    }

    @GetMapping("/periodo/{periodoId}/ambiente/{ambienteId}/fecha/{fecha}/hora/{hora}")
    public ResponseEntity<PlantillaReservaResponseDTO> getClaseEnMomento(
            @PathVariable Long periodoId,
            @PathVariable Long ambienteId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime hora) {

        return service
                .getClaseEnMomento(periodoId, ambienteId, fecha, hora)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                        log.warn("Clase no encontrada");
        return ResponseEntity.notFound().build();
            });
    }

}

