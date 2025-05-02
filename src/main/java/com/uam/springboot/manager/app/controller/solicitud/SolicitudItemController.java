package com.uam.springboot.manager.app.controller.solicitud;

import com.uam.springboot.manager.app.dto.solicitud.requestDTOs.SolicitudItemRequestDTO;
import com.uam.springboot.manager.app.dto.solicitud.responseDTOs.SolicitudItemResponseDTO;
import com.uam.springboot.manager.app.service.impl.solicitud.SolicitudItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitud-items")
public class SolicitudItemController {

    private final SolicitudItemService itemService;

    public SolicitudItemController(SolicitudItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudItemResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.findById(id));
    }

    @GetMapping("/solicitud/{solicitudId}")
    public ResponseEntity<List<SolicitudItemResponseDTO>> findBySolicitud(
            @PathVariable Long solicitudId) {
        List<SolicitudItemResponseDTO> items =
                itemService.findBySolicitud(solicitudId);
        return ResponseEntity.ok(items);
    }

    @PostMapping
    public ResponseEntity<SolicitudItemResponseDTO> create(
            @RequestBody SolicitudItemRequestDTO dto) {
        SolicitudItemResponseDTO created = itemService.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudItemResponseDTO> update(
            @PathVariable Long id,
            @RequestBody SolicitudItemRequestDTO dto) {
        SolicitudItemResponseDTO updated = itemService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        itemService.delete(id);
    }
}
