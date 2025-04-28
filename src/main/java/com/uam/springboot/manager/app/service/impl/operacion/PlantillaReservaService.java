package com.uam.springboot.manager.app.service.impl.operacion;

import com.uam.springboot.manager.app.dto.operacion.requestDTOs.PlantillaReservaRequestDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.PlantillaReservaResponseDTO;
import com.uam.springboot.manager.app.mapper.operacion.PlantillaReservaMapper;
import com.uam.springboot.manager.app.model.catalogos.DIASSEMANA;
import com.uam.springboot.manager.app.model.operacion.PlantillaReserva;
import com.uam.springboot.manager.app.repository.operacion.PlantillaReservaRepository;
import com.uam.springboot.manager.app.service.impl.CrudServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlantillaReservaService
        extends CrudServiceImpl<PlantillaReserva, PlantillaReservaRequestDTO, PlantillaReservaResponseDTO, Long> {

    private final PlantillaReservaRepository plantillaRepo;
    private final PlantillaReservaMapper mapper;

    public PlantillaReservaService(PlantillaReservaRepository repository,
                                   PlantillaReservaMapper mapper) {
        super(repository, mapper);
        this.plantillaRepo = repository;
        this.mapper = mapper;
    }

    /**
     * Nuevo método: busca por periodo y día de la semana.
     */
    public List<PlantillaReservaResponseDTO> findByPeriodoAndDia(Long periodoId, DIASSEMANA diaSemana) {
        return plantillaRepo.findByPeriodoIdAndDiaSemana(periodoId, diaSemana).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}

