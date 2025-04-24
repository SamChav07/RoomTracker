package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.PeriodoAcademicoRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.PeriodoAcademicoResponseDTO;
import com.uam.springboot.manager.app.model.catalogos.PeriodoAcademico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class PeriodoAcademicoMapper extends
        GenericCatalogoMapperBase<PeriodoAcademico, PeriodoAcademicoRequestDTO, PeriodoAcademicoResponseDTO> {}
