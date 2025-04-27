package com.uam.springboot.manager.app.dto.operacion.responseDTOs;

import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.UsuarioResponseDTO;

import java.time.LocalDateTime;

public record FeedbackResponseDTO(
        Long id,
        SolicitudItemResponseDTO solicitudItem,
        UsuarioResponseDTO usuario,
        LocalDateTime fecha,
        String comentario
) {}
