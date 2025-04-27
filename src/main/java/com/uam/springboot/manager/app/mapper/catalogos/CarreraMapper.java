package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.CarreraRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.CarreraResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Carrera;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={FacultadMapper.class})
public abstract class CarreraMapper extends GenericBaseMapper<Carrera, CarreraRequestDTO, CarreraResponseDTO> {
}