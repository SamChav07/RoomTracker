package com.uam.springboot.manager.app.dto.catalogos;

import java.util.Set;

public record AsignaturaResponseDTO(
        Long id,
        String codigo,
        String nombre,
        Integer capacidadSugeida,
        Set<Long> equipoIds
) {}