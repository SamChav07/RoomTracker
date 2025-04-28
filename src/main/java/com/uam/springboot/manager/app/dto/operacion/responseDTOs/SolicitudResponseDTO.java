package com.uam.springboot.manager.app.dto.operacion.responseDTOs;

import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.CoordinadorResponseDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.PeriodoAcademicoResponseDTO;
import com.uam.springboot.manager.app.model.operacion.ESTADOSOLICITUD;

import java.time.LocalDateTime;

public record SolicitudResponseDTO(
        Long id,
        LocalDateTime fechaCreacion,
        ESTADOSOLICITUD estado,
        CoordinadorResponseDTO coordinador,
        PeriodoAcademicoResponseDTO periodoAcademico
) {}