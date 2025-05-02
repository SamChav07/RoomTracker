package com.uam.springboot.manager.app.service.impl.solicitud;

import com.uam.springboot.manager.app.dto.solicitud.requestDTOs.SolicitudItemRequestDTO;
import com.uam.springboot.manager.app.dto.solicitud.responseDTOs.SolicitudItemResponseDTO;
import com.uam.springboot.manager.app.mapper.solicitud.SolicitudItemMapper;
import com.uam.springboot.manager.app.mapper.solicitud.SolicitudMapper;
import com.uam.springboot.manager.app.model.solicitud.Solicitud;
import com.uam.springboot.manager.app.model.solicitud.SolicitudItem;
import com.uam.springboot.manager.app.repository.solicitud.SolicitudItemRepository;
import com.uam.springboot.manager.app.repository.solicitud.SolicitudRepository;
import com.uam.springboot.manager.app.service.impl.CrudServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SolicitudItemService extends CrudServiceImpl<SolicitudItem, SolicitudItemRequestDTO, SolicitudItemResponseDTO, Long> {

    private final SolicitudRepository solRepo;


    public SolicitudItemService(SolicitudItemRepository itemRepo,
                                SolicitudItemMapper mapper,
                                SolicitudRepository solRepo) {
        super(itemRepo, mapper);
        this.solRepo = solRepo;
    }

    @Override
    public SolicitudItemResponseDTO create(SolicitudItemRequestDTO dto) {
        // Logica especifica si es necesaria (ej. ver estado de solicitud padre)
        SolicitudItem entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public List<SolicitudItemResponseDTO> findBySolicitud(Long solicitudId) {
        Solicitud sol = solRepo.findById(solicitudId)
                .orElseThrow(() -> new IllegalArgumentException("Solicitud no encontrada: " + solicitudId));
        return sol.getItems().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
