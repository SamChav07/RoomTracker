package com.uam.springboot.manager.app.dto.operacion.responseDTOs;

import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.UsuarioResponseDTO;

import java.time.LocalDateTime;

public record AjusteManualResponseDTO(
        Long id,
        PlanificacionResponseDTO planificacion,
        ReservaResponseDTO reservaOriginal,
        ReservaResponseDTO nuevaReserva,
        UsuarioResponseDTO usuario,
        LocalDateTime fecha,
        String comentario
) {}
