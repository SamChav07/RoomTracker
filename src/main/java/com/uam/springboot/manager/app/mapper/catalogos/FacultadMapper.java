package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.FacultadRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.FacultadResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Facultad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class FacultadMapper extends GenericBaseMapper<Facultad, FacultadRequestDTO, FacultadResponseDTO> {
}
