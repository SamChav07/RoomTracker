package com.uam.springboot.manager.app.dto.solicitud.responseDTOs;

import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.GrupoResponseDTO;
import com.uam.springboot.manager.app.model.solicitud.ESTADOITEM;

public record SolicitudItemResponseDTO(
        Long id,
        SolicitudResponseDTO solicitud,
        GrupoResponseDTO grupo,
        ESTADOITEM estadoItem
) {}