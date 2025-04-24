package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.CarreraRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.CarreraResponseDTO;
import com.uam.springboot.manager.app.model.catalogos.Carrera;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CarreraMapper extends GenericCatalogoMapperBase<Carrera, CarreraRequestDTO, CarreraResponseDTO> {}
