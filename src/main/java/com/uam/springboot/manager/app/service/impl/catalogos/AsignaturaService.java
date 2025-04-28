package com.uam.springboot.manager.app.service.impl.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.AsignaturaRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.AsignaturaResponseDTO;
import com.uam.springboot.manager.app.mapper.catalogos.AsignaturaMapper;
import com.uam.springboot.manager.app.model.catalogos.Asignatura;
import com.uam.springboot.manager.app.repository.catalogos.AsignaturaRepository;
import com.uam.springboot.manager.app.service.impl.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaService extends CrudServiceImpl<Asignatura, AsignaturaRequestDTO, AsignaturaResponseDTO, Long> {
    public AsignaturaService(AsignaturaRepository repository, AsignaturaMapper mapper) {
        super(repository, mapper);
    }
}