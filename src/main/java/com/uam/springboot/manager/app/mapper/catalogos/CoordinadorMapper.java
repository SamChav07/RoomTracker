package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.CoordinadorRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.CoordinadorResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Carrera;
import com.uam.springboot.manager.app.model.catalogos.Coordinador;
import com.uam.springboot.manager.app.model.catalogos.Usuario;
import com.uam.springboot.manager.app.repository.catalogos.CarreraRepository;
import com.uam.springboot.manager.app.repository.catalogos.UsuarioRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class, CarreraMapper.class})
public abstract class CoordinadorMapper extends GenericBaseMapper<Coordinador, CoordinadorRequestDTO, CoordinadorResponseDTO> {

    @Autowired
    protected UsuarioRepository usuarioRepo;

    @Autowired
    protected CarreraRepository carreraRepo;

    @Override
    @Mapping(target = "usuario", source = "usuarioId")
    @Mapping(target = "carreraCoordinada", source = "carreraId")
    public abstract Coordinador toEntity(CoordinadorRequestDTO dto);

    protected Usuario mapUsuarioId(Long id) {
        if (id == null) return null;
        return usuarioRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe Usuario para id=" + id));
    }

    protected Carrera mapCarreraId(Long id) {
        if (id == null) return null;
        return carreraRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe Carrera para id=" + id));
    }
}