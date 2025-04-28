package com.uam.springboot.manager.app.dto.catalogos.requestDTOs;

import jakarta.validation.constraints.NotNull;

public record OperadorLogisticaRequestDTO(
        @NotNull Long usuarioId
) {}
