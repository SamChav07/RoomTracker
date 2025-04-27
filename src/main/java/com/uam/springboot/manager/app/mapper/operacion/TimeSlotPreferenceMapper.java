package com.uam.springboot.manager.app.mapper.operacion;

import com.uam.springboot.manager.app.dto.operacion.requestDTOs.TimeSlotPreferenceRequestDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.TimeSlotPreferenceResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.mapper.catalogos.BloqueHorarioMapper;
import com.uam.springboot.manager.app.model.operacion.TimeSlotPreference;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {BloqueHorarioMapper.class})
public abstract class TimeSlotPreferenceMapper extends GenericBaseMapper<TimeSlotPreference, TimeSlotPreferenceRequestDTO, TimeSlotPreferenceResponseDTO> {
}
