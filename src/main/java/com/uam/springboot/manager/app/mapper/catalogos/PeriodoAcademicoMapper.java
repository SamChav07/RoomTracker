package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.PeriodoAcademicoRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.PeriodoAcademicoResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.PeriodoAcademico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class PeriodoAcademicoMapper extends
        GenericBaseMapper<PeriodoAcademico, PeriodoAcademicoRequestDTO, PeriodoAcademicoResponseDTO> {}
