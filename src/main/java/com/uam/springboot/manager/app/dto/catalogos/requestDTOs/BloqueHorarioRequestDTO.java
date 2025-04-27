package com.uam.springboot.manager.app.dto.catalogos.requestDTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import com.uam.springboot.manager.app.model.catalogos.DIASSEMANA;

import java.time.LocalTime;

public record BloqueHorarioRequestDTO(
        @NotNull DIASSEMANA dia,
        @NotNull LocalTime horaInicio,
        @NotNull LocalTime horaFin,
        @Min(1) Integer duracionMin
) {}
