package com.uam.springboot.manager.app.dto.catalogos.requestDTOs;

import jakarta.validation.constraints.NotBlank;

public record RolRequestDTO(
        @NotBlank String nombre
) {}
