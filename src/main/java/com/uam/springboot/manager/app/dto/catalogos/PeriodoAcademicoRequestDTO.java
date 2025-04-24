package com.uam.springboot.manager.app.dto.catalogos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PeriodoAcademicoRequestDTO(
        @NotBlank String codigo,
        @NotNull LocalDate fechaInicio,
        @NotNull LocalDate fechaFin,
        @Min(1) Integer semanasTotales
) {}
