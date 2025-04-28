package com.uam.springboot.manager.app.controller.catalogos;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.EquipoAmbienteRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.EquipoAmbienteResponseDTO;
import com.uam.springboot.manager.app.service.impl.catalogos.EquipoAmbienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/equipos")
public class EquipoAmbienteController {

    public EquipoAmbienteController(EquipoAmbienteService service) {
        this.service = service;
    }

    private final EquipoAmbienteService service;

    @PostMapping
    public ResponseEntity<EquipoAmbienteResponseDTO> create(@RequestBody @Valid EquipoAmbienteRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EquipoAmbienteResponseDTO> update(@PathVariable Long id, @RequestBody @Valid EquipoAmbienteRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id); return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoAmbienteResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping public ResponseEntity<List<EquipoAmbienteResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}