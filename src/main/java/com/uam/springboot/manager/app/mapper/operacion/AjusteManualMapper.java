package com.uam.springboot.manager.app.mapper.operacion;

import com.uam.springboot.manager.app.dto.operacion.requestDTOs.AjusteManualRequestDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.AjusteManualResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.mapper.catalogos.UsuarioMapper;
import com.uam.springboot.manager.app.model.operacion.AjusteManual;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PlanificacionMapper.class, ReservaMapper.class, UsuarioMapper.class})
public abstract class AjusteManualMapper extends GenericBaseMapper<AjusteManual, AjusteManualRequestDTO, AjusteManualResponseDTO> {
}