package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.GrupoRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.GrupoResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Asignatura;
import com.uam.springboot.manager.app.model.catalogos.Grupo;
import com.uam.springboot.manager.app.model.catalogos.Profesor;
import com.uam.springboot.manager.app.repository.catalogos.AsignaturaRepository;
import com.uam.springboot.manager.app.repository.catalogos.ProfesorRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {ProfesorMapper.class})
public abstract class GrupoMapper extends GenericBaseMapper<Grupo, GrupoRequestDTO, GrupoResponseDTO> {

    @Autowired
    protected ProfesorRepository profesorRepo;
    @Autowired
    protected AsignaturaRepository asignaturaRepo;

    @Override
    @Mapping(target = "profesor", source = "profesorId")
    @Mapping(target = "asignatura", source = "asignaturaId")
    public abstract Grupo toEntity(GrupoRequestDTO dto);

    protected Profesor mapProfesorId(Long id) {
        if (id == null) return null;
        return profesorRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe Profesor para id=" + id));
    }
    protected Asignatura mapAsignaturaId(Long id) {
        return asignaturaRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe Asignatura para id=" + id));
    }

}