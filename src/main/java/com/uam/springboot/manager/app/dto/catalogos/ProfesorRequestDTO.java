package com.uam.springboot.manager.app.dto.catalogos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfesorRequestDTO(
        @NotBlank String nombre,
        @NotNull Boolean necesitaAccesibilidad
) {}

