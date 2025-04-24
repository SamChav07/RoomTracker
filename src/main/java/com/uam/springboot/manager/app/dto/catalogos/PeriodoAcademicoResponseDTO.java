package com.uam.springboot.manager.app.dto.catalogos;

import java.time.LocalDate;

public record PeriodoAcademicoResponseDTO(
        Long id,
        String codigo,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        Integer semanasTotales
) {}
