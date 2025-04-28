package com.uam.springboot.manager.app.mapper.operacion;

import com.uam.springboot.manager.app.dto.operacion.requestDTOs.PlanificacionRequestDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.PlanificacionResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.mapper.catalogos.GrupoMapper;
import com.uam.springboot.manager.app.mapper.catalogos.UsuarioMapper;
import com.uam.springboot.manager.app.model.operacion.Planificacion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class, GrupoMapper.class})
public abstract class PlanificacionMapper extends GenericBaseMapper<Planificacion, PlanificacionRequestDTO, PlanificacionResponseDTO> {
}

