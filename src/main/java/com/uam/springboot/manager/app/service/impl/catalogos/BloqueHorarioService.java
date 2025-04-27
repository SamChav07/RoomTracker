package com.uam.springboot.manager.app.service.impl.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.BloqueHorarioRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.BloqueHorarioResponseDTO;
import com.uam.springboot.manager.app.mapper.catalogos.BloqueHorarioMapper;
import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import com.uam.springboot.manager.app.repository.catalogos.BloqueHorarioRepository;
import org.springframework.stereotype.Service;

@Service
public class BloqueHorarioService extends CrudServiceImpl<BloqueHorario, BloqueHorarioRequestDTO, BloqueHorarioResponseDTO, Long> {
    public BloqueHorarioService(BloqueHorarioRepository repository, BloqueHorarioMapper mapper) {
        super(repository, mapper);
    }
}

