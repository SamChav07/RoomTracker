package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.EquipoAmbienteRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.EquipoAmbienteResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.EquipoAmbiente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EquipoAmbienteMapper extends
        GenericBaseMapper<EquipoAmbiente, EquipoAmbienteRequestDTO, EquipoAmbienteResponseDTO> {}
