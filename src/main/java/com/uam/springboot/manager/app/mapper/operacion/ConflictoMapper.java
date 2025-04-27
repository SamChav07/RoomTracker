package com.uam.springboot.manager.app.mapper.operacion;


import com.uam.springboot.manager.app.dto.operacion.requestDTOs.ConflictoRequestDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.ConflictoResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.operacion.Conflicto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ReservaMapper.class})
public abstract class ConflictoMapper extends GenericBaseMapper<Conflicto, ConflictoRequestDTO, ConflictoResponseDTO> {
}