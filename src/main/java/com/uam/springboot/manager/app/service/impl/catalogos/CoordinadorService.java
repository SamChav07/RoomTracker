package com.uam.springboot.manager.app.service.impl.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.CoordinadorRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.CoordinadorResponseDTO;
import com.uam.springboot.manager.app.mapper.catalogos.CoordinadorMapper;
import com.uam.springboot.manager.app.model.catalogos.Coordinador;
import com.uam.springboot.manager.app.repository.catalogos.CoordinadorRepository;
import com.uam.springboot.manager.app.service.impl.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CoordinadorService extends CrudServiceImpl<Coordinador, CoordinadorRequestDTO, CoordinadorResponseDTO, Long> {
    public CoordinadorService(CoordinadorRepository repository, CoordinadorMapper mapper) {
        super(repository, mapper);
    }
}