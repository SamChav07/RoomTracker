package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.OperadorLogisticaRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.OperadorLogisticaResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.OperadorLogistica;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public abstract class OperadorLogisticaMapper extends
        GenericBaseMapper<OperadorLogistica, OperadorLogisticaRequestDTO, OperadorLogisticaResponseDTO> {
}