package com.uam.springboot.manager.app.dto.operacion.responseDTOs;

import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.AmbienteResponseDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.BloqueHorarioResponseDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.GrupoResponseDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.PeriodoAcademicoResponseDTO;
import com.uam.springboot.manager.app.dto.solicitud.responseDTOs.SolicitudItemResponseDTO;
import com.uam.springboot.manager.app.model.catalogos.DIASSEMANA;
import com.uam.springboot.manager.app.model.catalogos.Grupo;
import com.uam.springboot.manager.app.model.operacion.ESTADORESERVA;
import com.uam.springboot.manager.app.model.operacion.ORIGENRESERVA;

public record PlantillaReservaResponseDTO(
        Long id,
        PeriodoAcademicoResponseDTO periodo,
        DIASSEMANA diaSemana,
        AmbienteResponseDTO ambiente,
        BloqueHorarioResponseDTO timeSlot,
        GrupoResponseDTO grupo
        ) {}