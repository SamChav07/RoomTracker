package com.uam.springboot.manager.app.controller.solver;

import java.time.LocalDate;

import com.uam.springboot.manager.app.dto.solver.PlanificacionResultadoDTO;
import com.uam.springboot.manager.app.service.impl.solver.PlanificacionSolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para exponer la planificación diaria vía API REST.
 */
@RestController
@RequestMapping("/planificacion/solver")
public class PlanificacionSolverController {

    private final PlanificacionSolverService planificacionSolverService;

    @Autowired
    public PlanificacionSolverController(PlanificacionSolverService planificacionSolverService) {
        this.planificacionSolverService = planificacionSolverService;
    }

    /**
     * Ejecuta la planificación para el periodo y fecha indicados.
     *
     * Ejemplo de llamada:
     * GET /api/planificacion?periodoAcademicoId=3&fecha=2025-05-02
     *
     * @param periodoAcademicoId El ID del periodo académico
     * @param fecha              La fecha a planificar (formato ISO: yyyy-MM-dd)
     * @return DTO con las reservas asignadas y rechazadas
     */
    @GetMapping
    public ResponseEntity<PlanificacionResultadoDTO> planificarDia(
            @RequestParam("periodoAcademicoId") Long periodoAcademicoId,
            @RequestParam("fecha")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {

        PlanificacionResultadoDTO resultado =
                planificacionSolverService.planificarDia(periodoAcademicoId, fecha);
        return ResponseEntity.ok(resultado);
    }
}

