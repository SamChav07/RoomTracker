package com.uam.springboot.manager.app.mapper.operacion;

import com.uam.springboot.manager.app.dto.operacion.requestDTOs.ExcepcionReservaRequestDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.ExcepcionReservaResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Ambiente;
import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import com.uam.springboot.manager.app.model.catalogos.Grupo;
import com.uam.springboot.manager.app.model.operacion.ExcepcionReserva;
import com.uam.springboot.manager.app.model.operacion.PlantillaReserva;
import com.uam.springboot.manager.app.repository.catalogos.AmbienteRepository;
import com.uam.springboot.manager.app.repository.catalogos.BloqueHorarioRepository;
import com.uam.springboot.manager.app.repository.catalogos.GrupoRepository;
import com.uam.springboot.manager.app.repository.operacion.PlantillaReservaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ExcepcionReservaMapper extends GenericBaseMapper<ExcepcionReserva, ExcepcionReservaRequestDTO, ExcepcionReservaResponseDTO> {

    @Autowired
    protected AmbienteRepository ambienteRepo;
    @Autowired
    protected BloqueHorarioRepository bloqueHorarioRepo;
    @Autowired
    protected GrupoRepository grupoRepo;
    @Autowired
    protected PlantillaReservaRepository plantillaReservaRepo;

    @Override
    @Mapping(target="plantilla", source="plantillaId")
    @Mapping(target = "nuevoAmbiente", source = "ambienteId")
    @Mapping(target = "nuevoTimeSlot", source = "nuevoTimeSlotId")
    @Mapping(target= "grupo", source = "grupoId")
    public abstract ExcepcionReserva toEntity(ExcepcionReservaRequestDTO dto);

    protected Ambiente mapAmbienteId(Long id) {
        return ambienteRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe Ambiente para id=" + id));
    }
    protected BloqueHorario mapTimeSlotId(Long id) {
        return bloqueHorarioRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe TimeSlot para id=" + id));
    }
    protected Grupo mapGrupoId(Long id) {
        return grupoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe Grupo para id=" + id));
    }
    protected PlantillaReserva mapPlantillaReservaId(Long id) {
        return plantillaReservaRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe PlantillaReserva para id=" + id));
    }


}