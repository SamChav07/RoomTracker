package com.uam.springboot.manager.app.dto.solicitud.responseDTOs;

import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.CoordinadorResponseDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.PeriodoAcademicoResponseDTO;
import com.uam.springboot.manager.app.model.solicitud.ESTADOSOLICITUD;

import java.time.LocalDateTime;
import java.util.List;

public record SolicitudResponseDTO(
        Long id,
        LocalDateTime fechaSolicitud,
        CoordinadorResponseDTO coordinador,
        PeriodoAcademicoResponseDTO periodo,
        ESTADOSOLICITUD estado,
        List<SolicitudItemResponseDTO> solicitudesItem
) {}