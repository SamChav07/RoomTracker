package com.uam.springboot.manager.app.mapper.solicitud;

import com.uam.springboot.manager.app.dto.solicitud.requestDTOs.TimeSlotPreferenceRequestDTO;
import com.uam.springboot.manager.app.dto.solicitud.responseDTOs.TimeSlotPreferenceResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import com.uam.springboot.manager.app.model.solicitud.SolicitudItem;
import com.uam.springboot.manager.app.model.solicitud.TimeSlotPreference;
import com.uam.springboot.manager.app.repository.catalogos.BloqueHorarioRepository;
import com.uam.springboot.manager.app.repository.solicitud.SolicitudItemRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class TimeSlotPreferenceMapper extends GenericBaseMapper<TimeSlotPreference, TimeSlotPreferenceRequestDTO, TimeSlotPreferenceResponseDTO> {

    @Autowired
    protected SolicitudItemRepository solicitudItemRepo;
    @Autowired protected BloqueHorarioRepository timeSlotRepo;

    @Override
    @Mapping(target = "solicitudItem", source = "solicitudItemId")
    @Mapping(target = "timeSlot", source = "timeSlotId")
    public abstract TimeSlotPreference toEntity(TimeSlotPreferenceRequestDTO dto);

    protected SolicitudItem mapSolicitudItemId(Long id) {
        return solicitudItemRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe SolicitudItem para id=" + id));
    }
    protected BloqueHorario mapTimeSlotId(Long id) {
        return timeSlotRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe TimeSlot para id=" + id));
    }
}
