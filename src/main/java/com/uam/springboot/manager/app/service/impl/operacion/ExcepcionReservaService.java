package com.uam.springboot.manager.app.service.impl.operacion;

import com.uam.springboot.manager.app.dto.operacion.requestDTOs.ExcepcionReservaRequestDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.ExcepcionReservaResponseDTO;
import com.uam.springboot.manager.app.mapper.operacion.ExcepcionReservaMapper;
import com.uam.springboot.manager.app.mapper.operacion.PlantillaReservaMapper;
import com.uam.springboot.manager.app.model.operacion.ExcepcionReserva;
import com.uam.springboot.manager.app.repository.operacion.ExcepcionReservaRepository;
import com.uam.springboot.manager.app.repository.operacion.PlantillaReservaRepository;
import com.uam.springboot.manager.app.service.impl.CrudServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ExcepcionReservaService extends
        CrudServiceImpl<ExcepcionReserva, ExcepcionReservaRequestDTO, ExcepcionReservaResponseDTO, Long> {

    private final ExcepcionReservaRepository excepcionRepo;
    private final ExcepcionReservaMapper mapper;

    public ExcepcionReservaService(ExcepcionReservaRepository repository,
                                   ExcepcionReservaMapper mapper) {
        super(repository, mapper);
        this.excepcionRepo = repository;
        this.mapper = mapper;
    }

    public List<ExcepcionReservaResponseDTO> findByFecha(LocalDate fecha) {
        return excepcionRepo.findByFecha(fecha).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }



}
