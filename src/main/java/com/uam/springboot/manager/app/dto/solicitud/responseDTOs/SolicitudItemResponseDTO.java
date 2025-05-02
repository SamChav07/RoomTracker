package com.uam.springboot.manager.app.dto.solicitud.responseDTOs;

import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.GrupoResponseDTO;
import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import com.uam.springboot.manager.app.model.catalogos.DIASSEMANA;

import java.util.Set;

public record SolicitudItemResponseDTO(
        Long id,
        Set<DIASSEMANA> diasSemana,
        BloqueHorario bloqueInicio,
        Integer duracionBloques,
        GrupoResponseDTO grupo,
        Integer numeroGrupos,
        String observaciones
) {}