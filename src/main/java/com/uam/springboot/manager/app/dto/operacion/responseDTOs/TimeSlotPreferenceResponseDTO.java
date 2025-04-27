package com.uam.springboot.manager.app.dto.operacion.responseDTOs;

import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.BloqueHorarioResponseDTO;

public record TimeSlotPreferenceResponseDTO(
        Long id,
        BloqueHorarioResponseDTO timeSlot,
        Integer prioridad
) {}