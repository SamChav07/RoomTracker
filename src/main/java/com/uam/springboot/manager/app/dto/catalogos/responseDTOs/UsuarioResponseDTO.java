package com.uam.springboot.manager.app.dto.catalogos.responseDTOs;

import java.util.Set;

public record UsuarioResponseDTO(
        Long id,
        String email,
        String nombre,
        Set<RolResponseDTO> roles
) {}
