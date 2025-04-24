package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.EquipoAmbienteRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.EquipoAmbienteResponseDTO;
import com.uam.springboot.manager.app.model.catalogos.EquipoAmbiente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EquipoAmbienteMapper extends
        GenericCatalogoMapperBase<EquipoAmbiente, EquipoAmbienteRequestDTO, EquipoAmbienteResponseDTO> {}
