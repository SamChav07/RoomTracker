package com.uam.springboot.manager.app.service.impl.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.AmbienteRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.AmbienteResponseDTO;
import com.uam.springboot.manager.app.mapper.catalogos.AmbienteMapper;
import com.uam.springboot.manager.app.model.catalogos.Ambiente;
import com.uam.springboot.manager.app.repository.catalogos.AmbienteRepository;
import com.uam.springboot.manager.app.service.impl.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AmbienteService extends CrudServiceImpl<Ambiente, AmbienteRequestDTO, AmbienteResponseDTO, Long> {
    public AmbienteService(AmbienteRepository repository, AmbienteMapper mapper) {
        super(repository, mapper);
    }

}