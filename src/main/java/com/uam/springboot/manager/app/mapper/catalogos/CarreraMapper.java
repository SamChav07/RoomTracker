package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.CarreraRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.CarreraResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Carrera;
import com.uam.springboot.manager.app.model.catalogos.Facultad;
import com.uam.springboot.manager.app.repository.catalogos.FacultadRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {FacultadMapper.class})
public abstract class CarreraMapper extends GenericBaseMapper<Carrera, CarreraRequestDTO, CarreraResponseDTO> {

    @Autowired
    protected FacultadRepository facultadRepo;

    @Override
    @Mapping(target = "facultad", source = "facultadId")
    public abstract Carrera toEntity(CarreraRequestDTO dto);

    protected Facultad mapFacultadId(Long id) {
        if (id == null) return null;
        return facultadRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe Facultad para id=" + id));
    }
}