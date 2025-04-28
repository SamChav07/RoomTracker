package com.uam.springboot.manager.app.mapper.solicitud;

import com.uam.springboot.manager.app.dto.solicitud.requestDTOs.AjusteManualRequestDTO;
import com.uam.springboot.manager.app.dto.solicitud.responseDTOs.AjusteManualResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.Usuario;
import com.uam.springboot.manager.app.model.solicitud.AjusteManual;
import com.uam.springboot.manager.app.repository.catalogos.UsuarioRepository;
import com.uam.springboot.manager.app.repository.operacion.PlantillaReservaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class AjusteManualMapper extends GenericBaseMapper<AjusteManual, AjusteManualRequestDTO, AjusteManualResponseDTO> {

    @Autowired protected PlantillaReservaRepository reservaRepo;
    @Autowired protected UsuarioRepository usuarioRepo;

    @Override
    @Mapping(target = "usuario", source = "usuarioId")
    public abstract AjusteManual toEntity(AjusteManualRequestDTO dto);

    protected Usuario mapUsuarioId(Long id) {
        return usuarioRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe Usuario para id=" + id));
    }
}