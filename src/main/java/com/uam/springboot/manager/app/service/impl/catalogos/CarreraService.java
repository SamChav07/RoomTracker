package com.uam.springboot.manager.app.service.impl.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.CarreraRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.CarreraResponseDTO;
import com.uam.springboot.manager.app.mapper.catalogos.CarreraMapper;
import com.uam.springboot.manager.app.model.catalogos.Carrera;
import com.uam.springboot.manager.app.repository.catalogos.CarreraRepository;
import org.springframework.stereotype.Service;

@Service
public class CarreraService extends CrudServiceImpl<Carrera, CarreraRequestDTO, CarreraResponseDTO, Long> {
    public CarreraService(CarreraRepository repository, CarreraMapper mapper) {
        super(repository, mapper);
    }
}