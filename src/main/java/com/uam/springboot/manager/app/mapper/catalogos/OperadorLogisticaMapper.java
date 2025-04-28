package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.OperadorLogisticaRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.OperadorLogisticaResponseDTO;
import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.catalogos.OperadorLogistica;
import com.uam.springboot.manager.app.model.catalogos.Usuario;
import com.uam.springboot.manager.app.repository.catalogos.UsuarioRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public abstract class OperadorLogisticaMapper extends GenericBaseMapper<OperadorLogistica, OperadorLogisticaRequestDTO, OperadorLogisticaResponseDTO> {

    @Autowired
    protected UsuarioRepository usuarioRepo;

    @Override
    @Mapping(target = "usuario", source = "usuarioId")
    public abstract OperadorLogistica toEntity(OperadorLogisticaRequestDTO dto);

    protected Usuario mapUsuarioId(Long id) {
        if (id == null) return null;
        return usuarioRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe Usuario para id=" + id));
    }
}