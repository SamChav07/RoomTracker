package com.uam.springboot.manager.app.mapper.solicitud;

import com.uam.springboot.manager.app.dto.solicitud.requestDTOs.SolicitudItemRequestDTO;
import com.uam.springboot.manager.app.dto.solicitud.responseDTOs.SolicitudItemResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Grupo;
import com.uam.springboot.manager.app.model.solicitud.Solicitud;
import com.uam.springboot.manager.app.model.solicitud.SolicitudItem;
import com.uam.springboot.manager.app.repository.catalogos.GrupoRepository;
import com.uam.springboot.manager.app.repository.solicitud.SolicitudRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class SolicitudItemMapper extends GenericBaseMapper<SolicitudItem, SolicitudItemRequestDTO, SolicitudItemResponseDTO> {

    @Autowired
    protected SolicitudRepository solicitudRepo;
    @Autowired protected GrupoRepository grupoRepo;

    @Override
    @Mapping(target = "solicitud", source = "solicitudId")
    @Mapping(target = "grupo", source = "grupoId")
    public abstract SolicitudItem toEntity(SolicitudItemRequestDTO dto);

    protected Solicitud mapSolicitudId(Long id) {
        return solicitudRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe Solicitud para id=" + id));
    }
    protected Grupo mapGrupoId(Long id) {
        return grupoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe Grupo para id=" + id));
    }
}