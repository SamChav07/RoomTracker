package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.AsignaturaRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.AsignaturaResponseDTO;
import com.uam.springboot.manager.app.model.catalogos.Asignatura;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AsignaturaMapper extends
        GenericCatalogoMapperBase<Asignatura, AsignaturaRequestDTO, AsignaturaResponseDTO> {}
