package com.uam.springboot.manager.app.mapper.solicitud;

import com.uam.springboot.manager.app.dto.solicitud.requestDTOs.FeedbackRequestDTO;
import com.uam.springboot.manager.app.dto.solicitud.responseDTOs.FeedbackResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Usuario;
import com.uam.springboot.manager.app.model.solicitud.Feedback;
import com.uam.springboot.manager.app.model.solicitud.SolicitudItem;
import com.uam.springboot.manager.app.repository.catalogos.UsuarioRepository;
import com.uam.springboot.manager.app.repository.solicitud.SolicitudItemRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class FeedbackMapper extends GenericBaseMapper<Feedback, FeedbackRequestDTO, FeedbackResponseDTO> {

    @Autowired
    protected SolicitudItemRepository solicitudItemRepo;
    @Autowired protected UsuarioRepository usuarioRepo;

    @Override
    @Mapping(target = "solicitudItem", source = "solicitudItemId")
    @Mapping(target = "usuario", source = "usuarioId")
    public abstract Feedback toEntity(FeedbackRequestDTO dto);

    protected SolicitudItem mapSolicitudItemId(Long id) {
        return solicitudItemRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe SolicitudItem para id=" + id));
    }
    protected Usuario mapUsuarioId(Long id) {
        return usuarioRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe Usuario para id=" + id));
    }
}