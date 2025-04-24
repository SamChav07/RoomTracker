package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.BloqueHorarioRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.BloqueHorarioResponseDTO;
import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class BloqueHorarioMapper extends
        GenericCatalogoMapperBase<BloqueHorario, BloqueHorarioRequestDTO, BloqueHorarioResponseDTO> {}
