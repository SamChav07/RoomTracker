package com.uam.springboot.manager.app.dto.catalogos.requestDTOs;

import com.uam.springboot.manager.app.dto.RelationalRequestDTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.uam.springboot.manager.app.model.catalogos.ESTADOAMBIENTE;
import com.uam.springboot.manager.app.model.catalogos.TIPOAMBIENTE;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public record AmbienteRequestDTO(
        @NotBlank String codigo,
        @Min(1) Integer capacidad,
        @NotNull Boolean accesible,
        ESTADOAMBIENTE estado,
        TIPOAMBIENTE tipoAmbiente,
        @NotNull Set<Long> equiposAmbienteIds
) implements RelationalRequestDTO {

        @Override
        public Map<String, Set<Long>> getRelationIds() {
                Map<String, Set<Long>> map = new HashMap<>();
                map.put("equiposAmbiente", equiposAmbienteIds);
                return map;
        }
}

