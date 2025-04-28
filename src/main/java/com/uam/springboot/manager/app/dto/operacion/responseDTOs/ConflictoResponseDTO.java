package com.uam.springboot.manager.app.dto.operacion.responseDTOs;

import com.uam.springboot.manager.app.model.operacion.TIPOCONFLICTO;

public record ConflictoResponseDTO(
        Long id,
        ReservaResponseDTO reservaA,
        ReservaResponseDTO reservaB,
        TIPOCONFLICTO tipoConflicto
) {}
