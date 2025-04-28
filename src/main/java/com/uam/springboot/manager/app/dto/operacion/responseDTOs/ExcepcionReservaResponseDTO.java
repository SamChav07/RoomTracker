package com.uam.springboot.manager.app.dto.operacion.responseDTOs;

import com.uam.springboot.manager.app.model.catalogos.Ambiente;
import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import com.uam.springboot.manager.app.model.catalogos.Grupo;
import com.uam.springboot.manager.app.model.operacion.TIPOEXCEPCION;

import java.time.LocalDate;

public record ExcepcionReservaResponseDTO(
        Long id,
        PlantillaReservaResponseDTO plantilla,
        LocalDate fecha,
        TIPOEXCEPCION tipo,
        Ambiente nuevoAmbiente,
        BloqueHorario nuevoTimeSlot,
        Grupo grupo
) {
}
