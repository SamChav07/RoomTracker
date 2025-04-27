package com.uam.springboot.manager.app.mapper.operacion;

import com.uam.springboot.manager.app.dto.operacion.requestDTOs.SolicitudItemRequestDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.SolicitudItemResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.mapper.catalogos.GrupoMapper;
import com.uam.springboot.manager.app.model.operacion.SolicitudItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GrupoMapper.class, SolicitudMapper.class})
public abstract class SolicitudItemMapper extends GenericBaseMapper<SolicitudItem, SolicitudItemRequestDTO, SolicitudItemResponseDTO> {
}
