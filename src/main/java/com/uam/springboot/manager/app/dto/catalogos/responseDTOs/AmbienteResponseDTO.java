package com.uam.springboot.manager.app.dto.catalogos.responseDTOs;

import com.uam.springboot.manager.app.model.catalogos.ESTADOAMBIENTE;
import com.uam.springboot.manager.app.model.catalogos.TIPOAMBIENTE;

import java.util.Set;

public record AmbienteResponseDTO(
    Long id,
    String codigo,
    Integer capacidad,
    Boolean accesible,
    TIPOAMBIENTE tipoAmbiente,
    ESTADOAMBIENTE estado,
    Set<EquipoAmbienteResponseDTO> equiposAmbiente
) {
}
