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

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.AsignaturaRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.AsignaturaResponseDTO;
import com.uam.springboot.manager.app.service.impl.catalogos.AsignaturaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {
    private final AsignaturaService service;

    public AsignaturaController(AsignaturaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AsignaturaResponseDTO> create(@RequestBody @Valid AsignaturaRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignaturaResponseDTO> update(@PathVariable Long id, @RequestBody @Valid AsignaturaRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignaturaResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<AsignaturaResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}