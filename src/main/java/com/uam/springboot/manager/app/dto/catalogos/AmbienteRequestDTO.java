package com.uam.springboot.manager.app.dto.catalogos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.uam.springboot.manager.app.model.catalogos.ESTADOAMBIENTE;
import com.uam.springboot.manager.app.model.catalogos.TIPOAMBIENTE;

import java.util.Set;

public record AmbienteRequestDTO(
        @NotBlank String codigo,
        @Min(1) Integer capacidad,
        @NotNull Boolean accesible,
        ESTADOAMBIENTE estado,
        TIPOAMBIENTE tipoAmbiente,
        @NotNull Set<Long> equipoIds
        ) {
}
