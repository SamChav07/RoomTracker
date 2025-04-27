package com.uam.springboot.manager.app.dto.operacion.requestDTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record FeedbackRequestDTO(
        @NotNull Long solicitudItemId,
        @NotNull Long usuarioId,
        @NotNull LocalDateTime fecha,
        @Size(max = 500) String comentario
) {}
