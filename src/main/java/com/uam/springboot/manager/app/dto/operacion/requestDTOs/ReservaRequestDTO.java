package com.uam.springboot.manager.app.dto.operacion.requestDTOs;

import com.uam.springboot.manager.app.model.operacion.ESTADORESERVA;
import com.uam.springboot.manager.app.model.operacion.ORIGENRESERVA;
import jakarta.validation.constraints.NotNull;

public record ReservaRequestDTO(
        @NotNull Long solicitudItemId,
        @NotNull Long ambienteId,
        @NotNull Long timeSlotId,
        @NotNull ORIGENRESERVA origen,
        @NotNull ESTADORESERVA estadoReserva,
        Long planificacionId
) {}
