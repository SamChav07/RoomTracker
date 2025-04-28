package com.uam.springboot.manager.app.dto.solicitud.requestDTOs;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record TimeSlotPreferenceRequestDTO(
        @NotNull Long solicitudItemId,
        @NotNull Long timeSlotId,
        @Min(1) @Max(10) Integer prioridad
) {}