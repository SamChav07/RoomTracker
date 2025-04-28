package com.uam.springboot.manager.app.dto.solicitud.responseDTOs;

import com.uam.springboot.manager.app.model.solicitud.TIPOCONFLICTO;

public record ConflictoResponseDTO(
        Long id,
        TIPOCONFLICTO tipoConflicto
) {}
