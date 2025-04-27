package com.uam.springboot.manager.app.dto.operacion.responseDTOs;

import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.GrupoResponseDTO;
import com.uam.springboot.manager.app.model.operacion.ESTADOITEM;

public record SolicitudItemResponseDTO(
        Long id,
        SolicitudResponseDTO solicitud,
        GrupoResponseDTO grupo,
        ESTADOITEM estadoItem
) {}