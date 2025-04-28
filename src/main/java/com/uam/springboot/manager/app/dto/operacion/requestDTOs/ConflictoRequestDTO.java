package com.uam.springboot.manager.app.dto.operacion.requestDTOs;

import com.uam.springboot.manager.app.model.operacion.TIPOCONFLICTO;
import jakarta.validation.constraints.NotNull;

public record ConflictoRequestDTO(
        @NotNull Long reservaAId,
        @NotNull Long reservaBId,
        @NotNull TIPOCONFLICTO tipoConflicto
) {}
