package com.uam.springboot.manager.app.dto.catalogos.requestDTOs;

import jakarta.validation.constraints.NotNull;

public record CoordinadorRequestDTO(
        @NotNull Long usuarioId,
        @NotNull Long carreraId
) {}

