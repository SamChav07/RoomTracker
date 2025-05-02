package com.uam.springboot.manager.app.mapper.solicitud;


import com.uam.springboot.manager.app.dto.operacion.requestDTOs.PlantillaReservaRequestDTO;
import com.uam.springboot.manager.app.dto.solicitud.requestDTOs.SolicitudRequestDTO;
import com.uam.springboot.manager.app.dto.solicitud.responseDTOs.SolicitudResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.*;
import com.uam.springboot.manager.app.model.operacion.PlantillaReserva;
import com.uam.springboot.manager.app.model.solicitud.Solicitud;
import com.uam.springboot.manager.app.repository.catalogos.CoordinadorRepository;
import com.uam.springboot.manager.app.repository.catalogos.PeriodoAcademicoRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class SolicitudMapper extends GenericBaseMapper<Solicitud, SolicitudRequestDTO, SolicitudResponseDTO> {


    @Autowired
    protected CoordinadorRepository coordinadorRepository;
    @Autowired
    protected PeriodoAcademicoRepository periodoRepository;

    @Override
    @Mapping(target= "periodo", source= "periodoAcademicoId")
    @Mapping(target= "coordinador", source="coordinadorId")
    public abstract Solicitud toEntity(SolicitudRequestDTO dto);

    protected Coordinador mapCoordinador(Long id){
        return coordinadorRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("No existe el coordinador con el id: " + id));
    }

    protected PeriodoAcademico mapPeriodo(Long id){
        return periodoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("No existe el periodo con el id: " + id));
    }




}
