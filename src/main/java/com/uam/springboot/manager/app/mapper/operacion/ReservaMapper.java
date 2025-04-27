package com.uam.springboot.manager.app.mapper.operacion;

import com.uam.springboot.manager.app.dto.operacion.requestDTOs.ReservaRequestDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.ReservaResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.mapper.catalogos.AmbienteMapper;
import com.uam.springboot.manager.app.mapper.catalogos.BloqueHorarioMapper;
import com.uam.springboot.manager.app.mapper.catalogos.UsuarioMapper;
import com.uam.springboot.manager.app.model.operacion.Reserva;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class, AmbienteMapper.class, BloqueHorarioMapper.class, SolicitudItemMapper.class})
public abstract class ReservaMapper extends GenericBaseMapper<Reserva, ReservaRequestDTO, ReservaResponseDTO> {

}
