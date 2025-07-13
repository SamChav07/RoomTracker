package com.uam.springboot.manager.app.dto.catalogos.requestDTOs;

import com.uam.springboot.manager.app.controller.CrudMeta;
import jakarta.validation.constraints.NotBlank;

@CrudMeta(baseUrl = "/equipos")
public record EquipoAmbienteRequestDTO(
        @NotBlank String codigo,
        @NotBlank String descripcion
) {}
