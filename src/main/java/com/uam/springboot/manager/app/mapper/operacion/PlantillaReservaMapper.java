package com.uam.springboot.manager.app.mapper.operacion;

import com.uam.springboot.manager.app.dto.operacion.requestDTOs.PlantillaReservaRequestDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.PlantillaReservaResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Ambiente;
import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import com.uam.springboot.manager.app.model.catalogos.Grupo;
import com.uam.springboot.manager.app.model.operacion.PlantillaReserva;
import com.uam.springboot.manager.app.model.solicitud.SolicitudItem;
import com.uam.springboot.manager.app.repository.catalogos.AmbienteRepository;
import com.uam.springboot.manager.app.repository.catalogos.BloqueHorarioRepository;
import com.uam.springboot.manager.app.repository.catalogos.GrupoRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class PlantillaReservaMapper extends GenericBaseMapper<PlantillaReserva, PlantillaReservaRequestDTO, PlantillaReservaResponseDTO> {

    @Autowired
    protected AmbienteRepository ambienteRepo;
    @Autowired
    protected BloqueHorarioRepository bloqueHorarioRepo;
    @Autowired
    protected GrupoRepository grupoRepo;

    @Override
    @Mapping(target = "ambiente", source = "ambienteId")
    @Mapping(target = "timeSlot", source = "timeSlotId")
    @Mapping(target= "grupo", source = "grupoId")
    public abstract PlantillaReserva toEntity(PlantillaReservaRequestDTO dto);

    protected Ambiente mapAmbienteId(Long id) {
        return ambienteRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe Ambiente para id=" + id));
    }
    protected BloqueHorario mapTimeSlotId(Long id) {
        return bloqueHorarioRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe TimeSlot para id=" + id));
    }
    protected Grupo mapGrupoId(Long id) {
        return grupoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe Grupo para id=" + id));
    }

}
