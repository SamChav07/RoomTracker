package com.uam.springboot.manager.app.dto.catalogos;

import jakarta.validation.constraints.NotBlank;

public record CarreraRequestDTO(
        @NotBlank String codigo,
        @NotBlank String nombre
) {}
