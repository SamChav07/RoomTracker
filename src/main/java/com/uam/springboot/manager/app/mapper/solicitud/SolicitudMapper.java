package com.uam.springboot.manager.app.mapper.solicitud;

import com.uam.springboot.manager.app.dto.solicitud.requestDTOs.SolicitudRequestDTO;
import com.uam.springboot.manager.app.dto.solicitud.responseDTOs.SolicitudResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Coordinador;
import com.uam.springboot.manager.app.model.catalogos.PeriodoAcademico;
import com.uam.springboot.manager.app.model.solicitud.Solicitud;
import com.uam.springboot.manager.app.repository.catalogos.CoordinadorRepository;
import com.uam.springboot.manager.app.repository.catalogos.PeriodoAcademicoRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class SolicitudMapper extends GenericBaseMapper<Solicitud, SolicitudRequestDTO, SolicitudResponseDTO> {

    @Autowired
    protected CoordinadorRepository coordinadorRepo;
    @Autowired protected PeriodoAcademicoRepository periodoRepo;

    @Override
    @Mapping(target = "coordinador", source = "coordinadorId")
    @Mapping(target = "periodoAcademico", source = "periodoAcademicoId")
    public abstract Solicitud toEntity(SolicitudRequestDTO dto);

    protected Coordinador mapCoordinadorId(Long id) {
        return coordinadorRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe Coordinador para id=" + id));
    }
    protected PeriodoAcademico mapPeriodoAcademicoId(Long id) {
        return periodoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe Periodo Academico para id=" + id));
    }
}
