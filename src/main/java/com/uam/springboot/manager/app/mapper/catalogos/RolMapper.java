package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.RolRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.RolResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Rol;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RolMapper extends
        GenericBaseMapper<Rol, RolRequestDTO, RolResponseDTO> {
}