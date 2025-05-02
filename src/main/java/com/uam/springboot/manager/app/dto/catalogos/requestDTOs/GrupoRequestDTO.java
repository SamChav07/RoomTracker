package com.uam.springboot.manager.app.dto.catalogos.requestDTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record GrupoRequestDTO(
        @NotBlank Long asignaturaId,
        @NotBlank String codigo,
        @NotNull @Min(1)Integer numeroEstudiantes,
        @NotNull Long profesorId,
        @NotNull @Min(1) Integer numeroGrupo
        ) {
}
