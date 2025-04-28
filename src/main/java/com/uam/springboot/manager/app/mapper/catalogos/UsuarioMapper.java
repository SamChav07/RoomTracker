package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.UsuarioRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.UsuarioResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Rol;
import com.uam.springboot.manager.app.model.catalogos.Usuario;
import com.uam.springboot.manager.app.repository.catalogos.RolRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {RolMapper.class})
public abstract class UsuarioMapper extends GenericBaseMapper<Usuario, UsuarioRequestDTO, UsuarioResponseDTO> {

    @Autowired
    protected RolRepository rolRepo;

    @Override
    @Mapping(target = "roles", source = "rolIds")
    public abstract Usuario toEntity(UsuarioRequestDTO dto);

    protected Set<Rol> mapRolIds(Set<Long> ids) {
        if (ids == null || ids.isEmpty()) return Collections.emptySet();
        return new HashSet<>(rolRepo.findAllById(ids));
    }
}

