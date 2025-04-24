package com.uam.springboot.manager.app.dto.catalogos;

public record ProfesorResponseDTO(
        Long id,
        String nombre,
        Boolean necesitaAccesibilidad
) {}
