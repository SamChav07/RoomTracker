package com.uam.springboot.manager.app.service.impl.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.ProfesorRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.ProfesorResponseDTO;
import com.uam.springboot.manager.app.mapper.catalogos.ProfesorMapper;
import com.uam.springboot.manager.app.model.catalogos.Profesor;
import com.uam.springboot.manager.app.repository.catalogos.ProfesorRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService extends CrudServiceImpl<Profesor, ProfesorRequestDTO, ProfesorResponseDTO, Long> {
    public ProfesorService(ProfesorRepository repository, ProfesorMapper mapper) {
        super(repository, mapper);
    }
}