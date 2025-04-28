package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.GrupoRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.GrupoResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Grupo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProfesorMapper.class})
public abstract class GrupoMapper extends GenericBaseMapper<Grupo, GrupoRequestDTO, GrupoResponseDTO> {
}