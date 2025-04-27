package com.uam.springboot.manager.app.dto.catalogos.requestDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UsuarioRequestDTO(
        @NotBlank String email,
        @NotBlank String password,
        @NotBlank String nombre,
        @NotNull Set<Long> rolIds
) {}
