package com.uam.springboot.manager.app.dto.solicitud.requestDTOs;

import com.uam.springboot.manager.app.model.solicitud.ESTADOITEM;
import jakarta.validation.constraints.NotNull;

public record SolicitudItemRequestDTO(
        @NotNull Long solicitudId,
        @NotNull Long grupoId,
        @NotNull ESTADOITEM estadoItem
) {}