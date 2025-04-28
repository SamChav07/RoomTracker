package com.uam.springboot.manager.app.dto.solicitud.requestDTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record AjusteManualRequestDTO(
        @NotNull Long planificacionId,
        @NotNull Long reservaOriginalId,
        @NotNull Long nuevaReservaId,
        @NotNull Long usuarioId,
        @NotNull LocalDateTime fecha,
        @Size(max = 200) String comentario
) {}
