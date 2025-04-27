package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.UsuarioRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.UsuarioResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RolMapper.class})
public abstract class UsuarioMapper extends
        GenericBaseMapper<Usuario, UsuarioRequestDTO, UsuarioResponseDTO> {
}
