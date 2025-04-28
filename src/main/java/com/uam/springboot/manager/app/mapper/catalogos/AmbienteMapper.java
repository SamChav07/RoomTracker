package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.AmbienteRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.AmbienteResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Ambiente;
import com.uam.springboot.manager.app.model.catalogos.EquipoAmbiente;
import com.uam.springboot.manager.app.repository.catalogos.EquipoAmbienteRepository;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Mapper(componentModel = "spring", uses = {EquipoAmbienteMapper.class})
public abstract class AmbienteMapper
        extends GenericBaseMapper<Ambiente, AmbienteRequestDTO, AmbienteResponseDTO> {

    @Autowired
    protected EquipoAmbienteRepository equipoAmbienteRepo;

    @Override
    @Mapping(target = "equiposAmbiente", source = "equiposAmbienteIds")
    public abstract Ambiente toEntity(AmbienteRequestDTO dto);

    protected Set<EquipoAmbiente> mapEquiposAmbienteIds(Set<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptySet();
        }
        // findAllById devuelve List<EquipoAmbiente>, lo convertimos a Set
        return new HashSet<>(equipoAmbienteRepo.findAllById(ids));
    }
}




