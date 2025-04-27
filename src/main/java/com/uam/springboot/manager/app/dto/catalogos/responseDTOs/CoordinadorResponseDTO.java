package com.uam.springboot.manager.app.dto.catalogos.responseDTOs;

public record CoordinadorResponseDTO(
        Long id,
        UsuarioResponseDTO usuario,
        CarreraResponseDTO carreraCoordinada
) {}
