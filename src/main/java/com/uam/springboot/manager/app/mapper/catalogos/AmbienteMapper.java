package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.AmbienteRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.AmbienteResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Ambiente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {EquipoAmbienteMapper.class})
public abstract class AmbienteMapper extends
        GenericBaseMapper<Ambiente, AmbienteRequestDTO, AmbienteResponseDTO> {

}



