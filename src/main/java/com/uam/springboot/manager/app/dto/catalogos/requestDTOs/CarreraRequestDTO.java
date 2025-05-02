package com.uam.springboot.manager.app.dto.catalogos.requestDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CarreraRequestDTO(
        @NotBlank String codigo,
        @NotBlank String nombre,
        @NotNull Long facultadId
) {}
