package com.uam.springboot.manager.app.dto.operacion.requestDTOs;

import com.uam.springboot.manager.app.model.operacion.ESTADOPLANIFICACION;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record PlanificacionRequestDTO(
        @NotNull LocalDateTime fechaEjecucion,
        @NotNull Long responsableId,
        @NotNull ESTADOPLANIFICACION estadoPlan,
        @NotNull List<Long> noAsignadoGrupoIds
) {}