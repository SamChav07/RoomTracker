package com.uam.springboot.manager.app.dto.solicitud.responseDTOs;

import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.CoordinadorResponseDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.PeriodoAcademicoResponseDTO;
import com.uam.springboot.manager.app.model.solicitud.ESTADOSOLICITUD;

import java.time.LocalDateTime;

public record SolicitudResponseDTO(
        Long id,
        LocalDateTime fechaCreacion,
        ESTADOSOLICITUD estado,
        CoordinadorResponseDTO coordinador,
        PeriodoAcademicoResponseDTO periodoAcademico
) {}