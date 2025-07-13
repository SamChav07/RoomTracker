package com.uam.springboot.manager.app.dto.catalogos.requestDTOs;

import com.uam.springboot.manager.app.controller.CrudMeta;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import com.uam.springboot.manager.app.model.catalogos.DIASSEMANA;

import java.time.LocalTime;

@CrudMeta(baseUrl= "/bloques")
public record BloqueHorarioRequestDTO(
        @NotNull LocalTime horaInicio,
        @NotNull LocalTime horaFin,
        @Min(1) Integer duracionMin
) {}
