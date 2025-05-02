package com.uam.springboot.manager.app.mapper.solicitud;

import com.uam.springboot.manager.app.dto.operacion.requestDTOs.PlantillaReservaRequestDTO;
import com.uam.springboot.manager.app.dto.solicitud.requestDTOs.SolicitudItemRequestDTO;
import com.uam.springboot.manager.app.dto.solicitud.responseDTOs.SolicitudItemResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import com.uam.springboot.manager.app.model.catalogos.Coordinador;
import com.uam.springboot.manager.app.model.catalogos.Grupo;
import com.uam.springboot.manager.app.model.catalogos.PeriodoAcademico;
import com.uam.springboot.manager.app.model.solicitud.Solicitud;
import com.uam.springboot.manager.app.model.solicitud.SolicitudItem;
import com.uam.springboot.manager.app.repository.catalogos.BloqueHorarioRepository;
import com.uam.springboot.manager.app.repository.catalogos.CoordinadorRepository;
import com.uam.springboot.manager.app.repository.catalogos.GrupoRepository;
import com.uam.springboot.manager.app.repository.catalogos.PeriodoAcademicoRepository;
import com.uam.springboot.manager.app.repository.solicitud.SolicitudRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class SolicitudItemMapper extends GenericBaseMapper<SolicitudItem, SolicitudItemRequestDTO, SolicitudItemResponseDTO> {


    @Autowired
    protected SolicitudRepository solicitudRepository;
    @Autowired
    protected BloqueHorarioRepository bloqueHorarioRepository;
    @Autowired
    protected GrupoRepository grupoRepository;

    @Override
    @Mapping(target = "solicitud", source = "solicitudId")
    @Mapping(target = "bloqueInicio", source = "bloqueInicioId")
    @Mapping(target = "grupo", source = "grupoId")
    public abstract SolicitudItem toEntity(SolicitudItemRequestDTO dto);

    protected Solicitud mapSolicitud(Long id) {
        return solicitudRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se encontro el solicitud"));
    }

    protected BloqueHorario mapBloqueHorario(Long id) {
        return bloqueHorarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se encontro el bloque"));
    }

    protected Grupo mapGrupo(Long id) {
        return grupoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se encontro el grupo"));
    }
}