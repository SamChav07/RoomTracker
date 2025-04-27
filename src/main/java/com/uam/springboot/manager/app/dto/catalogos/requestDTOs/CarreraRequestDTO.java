package com.uam.springboot.manager.app.dto.catalogos.requestDTOs;

import com.uam.springboot.manager.app.model.catalogos.Facultad;
import jakarta.validation.constraints.NotBlank;

public record CarreraRequestDTO(
        @NotBlank String codigo,
        @NotBlank String nombre,
        @NotBlank Facultad facultad
) {}
