package com.uam.springboot.manager.app.mapper.operacion;

import com.uam.springboot.manager.app.dto.operacion.requestDTOs.SolicitudRequestDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.SolicitudResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.mapper.catalogos.CoordinadorMapper;
import com.uam.springboot.manager.app.mapper.catalogos.PeriodoAcademicoMapper;
import com.uam.springboot.manager.app.model.operacion.Solicitud;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CoordinadorMapper.class, PeriodoAcademicoMapper.class})
public abstract class SolicitudMapper extends GenericBaseMapper<Solicitud, SolicitudRequestDTO, SolicitudResponseDTO> {
}
