package com.uam.springboot.manager.app.dto.solicitud.requestDTOs;

import com.uam.springboot.manager.app.controller.CrudMeta;
import com.uam.springboot.manager.app.model.solicitud.ESTADOSOLICITUD;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@CrudMeta(baseUrl = "/solicitudes")
public record SolicitudRequestDTO(
        @NotNull Long coordinadorId,
        @NotNull Long periodoAcademicoId
) {}
