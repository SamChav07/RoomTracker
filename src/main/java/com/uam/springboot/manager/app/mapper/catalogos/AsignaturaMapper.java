package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.AsignaturaRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.AsignaturaResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Asignatura;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={EquipoAmbienteMapper.class})
public abstract class AsignaturaMapper extends
        GenericBaseMapper<Asignatura, AsignaturaRequestDTO, AsignaturaResponseDTO> {}
