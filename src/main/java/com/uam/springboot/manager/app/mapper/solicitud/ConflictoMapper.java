package com.uam.springboot.manager.app.mapper.solicitud;


import com.uam.springboot.manager.app.dto.solicitud.requestDTOs.ConflictoRequestDTO;
import com.uam.springboot.manager.app.dto.solicitud.responseDTOs.ConflictoResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.solicitud.Conflicto;
import com.uam.springboot.manager.app.repository.operacion.PlantillaReservaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ConflictoMapper extends GenericBaseMapper<Conflicto, ConflictoRequestDTO, ConflictoResponseDTO> {

    @Autowired
    protected PlantillaReservaRepository reservaRepo;

    @Override
    public abstract Conflicto toEntity(ConflictoRequestDTO dto);

}
