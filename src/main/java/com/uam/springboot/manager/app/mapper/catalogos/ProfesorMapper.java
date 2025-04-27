package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.ProfesorRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.ProfesorResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Profesor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProfesorMapper extends
        GenericBaseMapper<Profesor, ProfesorRequestDTO, ProfesorResponseDTO> {}
