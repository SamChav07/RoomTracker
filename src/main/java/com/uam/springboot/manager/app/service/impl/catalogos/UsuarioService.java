package com.uam.springboot.manager.app.service.impl.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.UsuarioRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.UsuarioResponseDTO;
import com.uam.springboot.manager.app.mapper.catalogos.UsuarioMapper;
import com.uam.springboot.manager.app.model.catalogos.Usuario;
import com.uam.springboot.manager.app.repository.catalogos.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends CrudServiceImpl<Usuario, UsuarioRequestDTO, UsuarioResponseDTO, Long> {
    public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper) {
        super(repository, mapper);
    }
}