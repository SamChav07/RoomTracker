package com.uam.springboot.manager.app.dto.catalogos.requestDTOs;

import com.uam.springboot.manager.app.model.catalogos.TIPOSEMESTRE;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PeriodoAcademicoRequestDTO(
        @NotBlank String codigo,
        @NotBlank String descripcion,
        @NotNull LocalDate fechaInicio,
        @NotNull LocalDate fechaFin,
        @Min(1) Integer semanasTotales,
        TIPOSEMESTRE tiposemestre
) {}
