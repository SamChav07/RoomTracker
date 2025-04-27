package com.uam.springboot.manager.app.dto.operacion.requestDTOs;

import com.uam.springboot.manager.app.model.operacion.ESTADOITEM;
import jakarta.validation.constraints.NotNull;

public record SolicitudItemRequestDTO(
        @NotNull Long solicitudId,
        @NotNull Long grupoId,
        @NotNull ESTADOITEM estadoItem
) {}