package com.uam.springboot.manager.app.controller.catalogos;

import jakarta.validation.Valid;
import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.ProfesorRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.ProfesorResponseDTO;
import com.uam.springboot.manager.app.service.impl.catalogos.ProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    private final ProfesorService service;

    public ProfesorController(ProfesorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProfesorResponseDTO> create(@RequestBody @Valid ProfesorRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorResponseDTO> update(@PathVariable Long id, @RequestBody @Valid ProfesorRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProfesorResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}