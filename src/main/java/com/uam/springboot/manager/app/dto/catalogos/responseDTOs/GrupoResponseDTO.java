package com.uam.springboot.manager.app.dto.catalogos.responseDTOs;

public record GrupoResponseDTO(
        Long id,
        AsignaturaResponseDTO asignatura,
        String codigo,
        Integer numeroEstudiantes,
        ProfesorResponseDTO profesor,
        Integer numeroGrupo
) {
}
