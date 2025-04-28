package com.uam.springboot.manager.app.dto.catalogos.responseDTOs;

public record ProfesorResponseDTO(
        Long id,
        String nombre,
        String email,
        Boolean necesitaAccesibilidad
) {}
