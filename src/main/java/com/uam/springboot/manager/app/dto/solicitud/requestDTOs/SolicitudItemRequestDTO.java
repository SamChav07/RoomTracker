package com.uam.springboot.manager.app.dto.solicitud.requestDTOs;

import com.uam.springboot.manager.app.model.catalogos.DIASSEMANA;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record SolicitudItemRequestDTO(
        @NotNull Long solicitudId,
        @NotNull @Enumerated(EnumType.STRING) Set<DIASSEMANA> diasSemana,
        @NotNull Long bloqueInicioId,
        @NotNull Integer duracionBloques,
        @NotNull Long grupoId,
        @NotNull @Min(1) Integer numeroGrupos,
        String observaciones

) {}