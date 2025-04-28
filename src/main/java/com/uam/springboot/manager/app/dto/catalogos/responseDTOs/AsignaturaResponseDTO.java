package com.uam.springboot.manager.app.dto.catalogos.responseDTOs;

import java.util.Set;

public record AsignaturaResponseDTO(
        Long id,
        String codigo,
        String nombre,
        Integer capacidadSugerida,
        Set<EquipoAmbienteResponseDTO> equiposNecesarios
) {}