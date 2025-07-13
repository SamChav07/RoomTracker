package com.uam.springboot.manager.app.dto.catalogos.requestDTOs;

import com.uam.springboot.manager.app.controller.CrudMeta;
import jakarta.validation.constraints.NotBlank;

@CrudMeta(baseUrl = "/roles")
public record RolRequestDTO(
        @NotBlank String nombre
) {}
