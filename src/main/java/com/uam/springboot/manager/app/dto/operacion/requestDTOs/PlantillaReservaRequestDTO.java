package com.uam.springboot.manager.app.dto.operacion.requestDTOs;

import com.uam.springboot.manager.app.controller.CrudMeta;
import com.uam.springboot.manager.app.model.catalogos.DIASSEMANA;
import jakarta.validation.constraints.NotNull;

@CrudMeta(baseUrl = "/plantillas")
public record PlantillaReservaRequestDTO(
        @NotNull Long periodoId,
        @NotNull DIASSEMANA diaSemana,
        @NotNull Long ambienteId,
        @NotNull Long timeSlotId,
        @NotNull Long grupoId
) {}
