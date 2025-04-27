package com.uam.springboot.manager.app.dto.catalogos.requestDTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record AsignaturaRequestDTO(
        @NotBlank String codigo,
        @NotBlank String nombre,
        @Min(1) Integer capacidadSugeida,
        @NotNull Set<Long> equipoIds
) {}
