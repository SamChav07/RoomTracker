package com.uam.springboot.manager.app.dto.solicitud.requestDTOs;

import com.uam.springboot.manager.app.model.solicitud.ESTADOSOLICITUD;
import jakarta.validation.constraints.NotNull;

public record SolicitudRequestDTO(
        @NotNull Long coordinadorId,
        @NotNull Long periodoAcademicoId,
        @NotNull ESTADOSOLICITUD estado
) {}
