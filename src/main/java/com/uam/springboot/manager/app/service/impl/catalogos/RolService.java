package com.uam.springboot.manager.app.service.impl.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.RolRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.RolResponseDTO;
import com.uam.springboot.manager.app.mapper.catalogos.RolMapper;
import com.uam.springboot.manager.app.model.catalogos.Rol;
import com.uam.springboot.manager.app.repository.catalogos.RolRepository;
import com.uam.springboot.manager.app.service.impl.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RolService extends CrudServiceImpl<Rol, RolRequestDTO, RolResponseDTO, Long> {
    public RolService(RolRepository repository, RolMapper mapper) {
        super(repository, mapper);
    }
}