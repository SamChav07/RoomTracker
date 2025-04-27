package com.uam.springboot.manager.app.dto.catalogos.requestDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfesorRequestDTO(
        @NotBlank String nombre,
        @Email String email,
        @NotNull Boolean necesitaAccesibilidad
) {}

