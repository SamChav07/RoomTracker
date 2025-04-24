package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.AmbienteRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.AmbienteResponseDTO;
import com.uam.springboot.manager.app.model.catalogos.Ambiente;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public abstract class AmbienteMapper extends
        GenericCatalogoMapperBase<Ambiente, AmbienteRequestDTO, AmbienteResponseDTO> {}
