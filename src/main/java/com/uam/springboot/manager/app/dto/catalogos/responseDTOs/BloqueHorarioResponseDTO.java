package com.uam.springboot.manager.app.dto.catalogos.responseDTOs;

import com.uam.springboot.manager.app.model.catalogos.DIASSEMANA;

import java.time.LocalTime;

public record BloqueHorarioResponseDTO(
        Long id,
        LocalTime horaInicio,
        LocalTime horaFin,
        Integer duracionMin
) {}
