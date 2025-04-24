package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.ProfesorRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.ProfesorResponseDTO;
import com.uam.springboot.manager.app.model.catalogos.Profesor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProfesorMapper extends
        GenericCatalogoMapperBase<Profesor, ProfesorRequestDTO, ProfesorResponseDTO> {}
