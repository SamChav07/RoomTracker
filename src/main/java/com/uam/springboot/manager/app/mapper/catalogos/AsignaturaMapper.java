package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.AsignaturaRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.AsignaturaResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Asignatura;
import com.uam.springboot.manager.app.model.catalogos.EquipoAmbiente;
import com.uam.springboot.manager.app.repository.catalogos.EquipoAmbienteRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {EquipoAmbienteMapper.class})
public abstract class AsignaturaMapper extends GenericBaseMapper<Asignatura, AsignaturaRequestDTO, AsignaturaResponseDTO> {

    @Autowired
    protected EquipoAmbienteRepository equipoAmbienteRepo;

    @Override
    @Mapping(target = "equiposNecesarios", source = "equiposNecesariosIds")
    public abstract Asignatura toEntity(AsignaturaRequestDTO dto);

    protected Set<EquipoAmbiente> mapEquiposNecesariosIds(Set<Long> ids) {
        if (ids == null || ids.isEmpty()) return Collections.emptySet();
        return new HashSet<>(equipoAmbienteRepo.findAllById(ids));
    }
}