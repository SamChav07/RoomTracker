package com.uam.springboot.manager.app.dto.catalogos.responseDTOs;

import com.uam.springboot.manager.app.model.catalogos.Facultad;

public record CarreraResponseDTO(
        Long id,
        String codigo,
        String nombre,
        FacultadResponseDTO facultad
) {}
