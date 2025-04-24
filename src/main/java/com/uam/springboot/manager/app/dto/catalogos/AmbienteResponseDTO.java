package com.uam.springboot.manager.app.dto.catalogos;

import com.uam.springboot.manager.app.model.catalogos.ESTADOAMBIENTE;
import com.uam.springboot.manager.app.model.catalogos.TIPOAMBIENTE;

import java.util.Set;

public record AmbienteResponseDTO(
    Long id,
    String codigo,
    Integer capacidad,
    Boolean accesible,
    TIPOAMBIENTE tipoambiente,
    ESTADOAMBIENTE estado,
    Set<Long> equipoIds
) {
}
