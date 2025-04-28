package com.uam.springboot.manager.app.service.impl.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.EquipoAmbienteRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.EquipoAmbienteResponseDTO;
import com.uam.springboot.manager.app.mapper.catalogos.EquipoAmbienteMapper;
import com.uam.springboot.manager.app.model.catalogos.EquipoAmbiente;
import com.uam.springboot.manager.app.repository.catalogos.EquipoAmbienteRepository;
import com.uam.springboot.manager.app.service.impl.CrudServiceImpl;
import org.springframework.stereotype.Service;

    @Service
    public class EquipoAmbienteService extends CrudServiceImpl<EquipoAmbiente, EquipoAmbienteRequestDTO, EquipoAmbienteResponseDTO, Long> {
        public EquipoAmbienteService(EquipoAmbienteRepository repository, EquipoAmbienteMapper mapper) {
            super(repository, mapper);
        }

    }