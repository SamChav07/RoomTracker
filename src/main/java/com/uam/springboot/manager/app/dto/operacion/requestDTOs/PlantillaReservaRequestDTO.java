package com.uam.springboot.manager.app.dto.operacion.requestDTOs;

import com.uam.springboot.manager.app.model.catalogos.DIASSEMANA;
import com.uam.springboot.manager.app.model.catalogos.PeriodoAcademico;
import jakarta.validation.constraints.NotNull;

public record PlantillaReservaRequestDTO(
        @NotNull PeriodoAcademico periodo,
        @NotNull DIASSEMANA dias,
        @NotNull Long ambienteId,
        @NotNull Long timeSlotId,
        @NotNull Long grupoId
) {}
