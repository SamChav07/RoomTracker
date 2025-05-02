package com.uam.springboot.manager.app.dto.catalogos.responseDTOs;

import com.uam.springboot.manager.app.model.catalogos.TIPOSEMESTRE;

import java.time.LocalDate;

public record PeriodoAcademicoResponseDTO(
        Long id,
        String codigo,
        String descripcion,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        Integer semanasTotales,
        TIPOSEMESTRE tiposemestre
) {}
