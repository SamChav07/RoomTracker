package com.uam.springboot.manager.app.service.impl.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.PeriodoAcademicoRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.PeriodoAcademicoResponseDTO;
import com.uam.springboot.manager.app.mapper.catalogos.PeriodoAcademicoMapper;
import com.uam.springboot.manager.app.model.catalogos.PeriodoAcademico;
import com.uam.springboot.manager.app.repository.catalogos.PeriodoAcademicoRepository;
import org.springframework.stereotype.Service;

@Service
public class PeriodoAcademicoService extends CrudServiceImpl<PeriodoAcademico, PeriodoAcademicoRequestDTO, PeriodoAcademicoResponseDTO, Long> {
    public PeriodoAcademicoService(PeriodoAcademicoRepository repository, PeriodoAcademicoMapper mapper) {
        super(repository, mapper);
    }
}