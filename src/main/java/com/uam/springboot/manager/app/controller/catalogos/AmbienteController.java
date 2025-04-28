package com.uam.springboot.manager.app.controller.catalogos;

import jakarta.validation.Valid;
import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.AmbienteRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.AmbienteResponseDTO;
import com.uam.springboot.manager.app.service.impl.catalogos.AmbienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ambientes")
public class AmbienteController {
    private final AmbienteService service;

    public AmbienteController(AmbienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AmbienteResponseDTO> create(@RequestBody @Valid AmbienteRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AmbienteResponseDTO> update(@PathVariable Long id, @RequestBody @Valid AmbienteRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmbienteResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<AmbienteResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}


