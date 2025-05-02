package com.uam.springboot.manager.app.service.impl.solicitud;

import com.uam.springboot.manager.app.dto.solicitud.requestDTOs.SolicitudRequestDTO;
import com.uam.springboot.manager.app.dto.solicitud.responseDTOs.SolicitudResponseDTO;
import com.uam.springboot.manager.app.mapper.solicitud.SolicitudMapper;
import com.uam.springboot.manager.app.model.solicitud.ESTADOSOLICITUD;
import com.uam.springboot.manager.app.model.solicitud.Solicitud;
import com.uam.springboot.manager.app.repository.solicitud.SolicitudRepository;
import com.uam.springboot.manager.app.service.impl.CrudServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SolicitudService extends CrudServiceImpl<Solicitud, SolicitudRequestDTO, SolicitudResponseDTO, Long> {

    public SolicitudService(SolicitudRepository repository, SolicitudMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public SolicitudResponseDTO create(SolicitudRequestDTO dto) {
        Solicitud entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public SolicitudResponseDTO changeEstado(Long id, ESTADOSOLICITUD estado) {

        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("No se encontró la solicitud con el " + id);
        }
        Solicitud entity = repository.getById(id);
        entity.setEstado(estado);
        return mapper.toDto(repository.save(entity));
    }

    public List<SolicitudResponseDTO> findAllByEstado(ESTADOSOLICITUD estado) {
        SolicitudRepository solicitudRepo = (SolicitudRepository) this.repository;

        List<Solicitud> solicitudes = solicitudRepo.findAllByEstado(estado);

        return mapper.toDtoList(solicitudes);
    }


}
