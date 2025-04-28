package com.uam.springboot.manager.app.dto.operacion.requestDTOs;

import com.uam.springboot.manager.app.model.catalogos.Ambiente;
import com.uam.springboot.manager.app.model.operacion.TIPOEXCEPCION;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ExcepcionReservaRequestDTO(
        @NotNull Long plantillaId,
        @NotNull LocalDate fecha,
        @NotNull TIPOEXCEPCION tipo,
        Long ambienteId,
        Long nuevoTimeSlotId,
        Long grupoId
        ) {
}
