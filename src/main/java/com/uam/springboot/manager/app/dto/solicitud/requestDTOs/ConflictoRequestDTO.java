package com.uam.springboot.manager.app.dto.solicitud.requestDTOs;

import com.uam.springboot.manager.app.model.solicitud.TIPOCONFLICTO;
import jakarta.validation.constraints.NotNull;

public record ConflictoRequestDTO(
        @NotNull Long reservaAId,
        @NotNull Long reservaBId,
        @NotNull TIPOCONFLICTO tipoConflicto
) {}
