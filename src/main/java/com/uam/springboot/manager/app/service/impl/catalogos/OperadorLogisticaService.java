package com.uam.springboot.manager.app.service.impl.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.OperadorLogisticaRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.OperadorLogisticaResponseDTO;
import com.uam.springboot.manager.app.mapper.catalogos.OperadorLogisticaMapper;
import com.uam.springboot.manager.app.model.catalogos.OperadorLogistica;
import com.uam.springboot.manager.app.repository.catalogos.OperadorLogisticaRepository;
import com.uam.springboot.manager.app.service.impl.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OperadorLogisticaService extends CrudServiceImpl<OperadorLogistica, OperadorLogisticaRequestDTO, OperadorLogisticaResponseDTO, Long> {
    public OperadorLogisticaService(OperadorLogisticaRepository repository, OperadorLogisticaMapper mapper) {
        super(repository, mapper);
    }
}