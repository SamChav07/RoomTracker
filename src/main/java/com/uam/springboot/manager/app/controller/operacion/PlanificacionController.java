package com.uam.springboot.manager.app.controller.operacion;

import com.uam.springboot.manager.app.dto.operacion.responseDTOs.PlantillaReservaResponseDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.SimplePlantillaReservaResponseDTO;
import com.uam.springboot.manager.app.service.impl.operacion.PlanificacionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

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

}

