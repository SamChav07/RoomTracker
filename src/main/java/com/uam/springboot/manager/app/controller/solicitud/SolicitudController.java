package com.uam.springboot.manager.app.controller.solicitud;

import com.uam.springboot.manager.app.dto.solicitud.requestDTOs.SolicitudRequestDTO;
import com.uam.springboot.manager.app.dto.solicitud.responseDTOs.SolicitudResponseDTO;
import com.uam.springboot.manager.app.model.solicitud.ESTADOSOLICITUD;
import com.uam.springboot.manager.app.service.impl.solicitud.SolicitudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @GetMapping
    public ResponseEntity<List<SolicitudResponseDTO>> findAll() {
        return ResponseEntity.ok(solicitudService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(solicitudService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SolicitudResponseDTO> create(
            @RequestBody SolicitudRequestDTO dto) {
        SolicitudResponseDTO created = solicitudService.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<SolicitudResponseDTO> changeEstado(
            @PathVariable Long id,
            @RequestParam ESTADOSOLICITUD estado) {
        return ResponseEntity.ok(solicitudService.changeEstado(id, estado));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        solicitudService.delete(id);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<SolicitudResponseDTO>> findAllByEstado(
            @PathVariable ESTADOSOLICITUD estado) {
        return ResponseEntity.ok(solicitudService.findAllByEstado(estado));
    }
}
