package com.uam.springboot.manager.app.service.impl.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.GrupoRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.GrupoResponseDTO;
import com.uam.springboot.manager.app.mapper.catalogos.GrupoMapper;
import com.uam.springboot.manager.app.model.catalogos.Grupo;
import com.uam.springboot.manager.app.repository.catalogos.GrupoRepository;
import com.uam.springboot.manager.app.service.impl.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class GrupoService extends CrudServiceImpl<Grupo, GrupoRequestDTO, GrupoResponseDTO, Long> {
    public GrupoService(GrupoRepository repository, GrupoMapper mapper) {
        super(repository, mapper);
    }
}
