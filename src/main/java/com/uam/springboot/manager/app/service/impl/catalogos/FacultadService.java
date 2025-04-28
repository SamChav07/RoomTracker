package com.uam.springboot.manager.app.service.impl.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.FacultadRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.FacultadResponseDTO;
import com.uam.springboot.manager.app.mapper.catalogos.FacultadMapper;
import com.uam.springboot.manager.app.model.catalogos.Facultad;
import com.uam.springboot.manager.app.repository.catalogos.FacultadRepository;
import com.uam.springboot.manager.app.service.impl.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class FacultadService extends CrudServiceImpl<Facultad, FacultadRequestDTO, FacultadResponseDTO, Long>
{
    public FacultadService(FacultadRepository repository, FacultadMapper mapper) {
        super(repository, mapper);
    }

}
