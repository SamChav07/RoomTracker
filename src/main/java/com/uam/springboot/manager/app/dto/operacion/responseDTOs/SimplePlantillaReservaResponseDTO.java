package com.uam.springboot.manager.app.dto.operacion.responseDTOs;

public record SimplePlantillaReservaResponseDTO(
        Long plantillaId,
        Long ambienteId,
        Long timeSlotId,
        Long grupoId
) {}

