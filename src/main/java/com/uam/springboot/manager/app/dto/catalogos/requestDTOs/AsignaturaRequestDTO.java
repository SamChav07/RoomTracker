package com.uam.springboot.manager.app.dto.catalogos.requestDTOs;

import java.util.Set;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AsignaturaRequestDTO(
        @NotBlank String codigo,
        @NotBlank String nombre,
        @Min(1) Integer capacidadSugerida,
        @NotNull Set<Long> equipoIds
) {}
