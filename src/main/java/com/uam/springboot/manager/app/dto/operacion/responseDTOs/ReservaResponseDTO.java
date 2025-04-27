package com.uam.springboot.manager.app.dto.operacion.responseDTOs;

import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.AmbienteResponseDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.BloqueHorarioResponseDTO;
import com.uam.springboot.manager.app.model.operacion.ESTADORESERVA;
import com.uam.springboot.manager.app.model.operacion.ORIGENRESERVA;

public record ReservaResponseDTO(
        Long id,
        SolicitudItemResponseDTO solicitudItem,
        AmbienteResponseDTO ambiente,
        BloqueHorarioResponseDTO timeSlot,
        ORIGENRESERVA origen,
        ESTADORESERVA estadoReserva
) {}