package com.uam.springboot.manager.app.dto.operacion.requestDTOs;

import com.uam.springboot.manager.app.model.operacion.ESTADOSOLICITUD;
import jakarta.validation.constraints.NotNull;

public record SolicitudRequestDTO(
        @NotNull Long coordinadorId,
        @NotNull Long periodoAcademicoId,
        @NotNull ESTADOSOLICITUD estado
) {}
