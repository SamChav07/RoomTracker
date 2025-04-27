package com.uam.springboot.manager.app.dto.operacion.responseDTOs;

import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.GrupoResponseDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.UsuarioResponseDTO;
import com.uam.springboot.manager.app.model.operacion.ESTADOPLANIFICACION;

import java.time.LocalDateTime;
import java.util.List;

public record PlanificacionResponseDTO(
        Long id,
        LocalDateTime fechaEjecucion,
        UsuarioResponseDTO responsable,
        ESTADOPLANIFICACION estadoPlan,
        List<GrupoResponseDTO> noAsignados
) {}
