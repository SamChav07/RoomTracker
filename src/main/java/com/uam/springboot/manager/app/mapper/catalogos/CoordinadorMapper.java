package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.CoordinadorRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.CoordinadorResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Coordinador;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class, CarreraMapper.class})
public abstract class CoordinadorMapper extends GenericBaseMapper<Coordinador, CoordinadorRequestDTO, CoordinadorResponseDTO> {
}