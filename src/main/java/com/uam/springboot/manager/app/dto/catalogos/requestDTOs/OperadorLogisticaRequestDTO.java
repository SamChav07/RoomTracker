package com.uam.springboot.manager.app.dto.catalogos.requestDTOs;

import com.uam.springboot.manager.app.controller.CrudMeta;
import jakarta.validation.constraints.NotNull;

@CrudMeta(baseUrl = "/operadores-logisitca")
public record OperadorLogisticaRequestDTO(
        @NotNull Long usuarioId
) {}
