package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.BloqueHorarioRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.BloqueHorarioResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class BloqueHorarioMapper extends
        GenericBaseMapper<BloqueHorario, BloqueHorarioRequestDTO, BloqueHorarioResponseDTO> {}
