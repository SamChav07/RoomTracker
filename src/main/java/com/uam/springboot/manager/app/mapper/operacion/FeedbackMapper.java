package com.uam.springboot.manager.app.mapper.operacion;

import com.uam.springboot.manager.app.dto.operacion.requestDTOs.FeedbackRequestDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.FeedbackResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.mapper.catalogos.UsuarioMapper;
import com.uam.springboot.manager.app.model.operacion.Feedback;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SolicitudItemMapper.class, UsuarioMapper.class})
public abstract class FeedbackMapper extends GenericBaseMapper<Feedback, FeedbackRequestDTO, FeedbackResponseDTO> {
}