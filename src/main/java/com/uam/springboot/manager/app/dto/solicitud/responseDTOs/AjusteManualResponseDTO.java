package com.uam.springboot.manager.app.dto.solicitud.responseDTOs;

import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.UsuarioResponseDTO;

import java.time.LocalDateTime;

public record AjusteManualResponseDTO(
        Long id,
        UsuarioResponseDTO usuario,
        LocalDateTime fecha,
        String comentario
) {}
