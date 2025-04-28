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

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.CarreraRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.CarreraResponseDTO;
import com.uam.springboot.manager.app.service.impl.catalogos.CarreraService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/carreras")
public class CarreraController {
    private final CarreraService service;

    public CarreraController(CarreraService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CarreraResponseDTO> create(@RequestBody @Valid CarreraRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarreraResponseDTO> update(@PathVariable Long id, @RequestBody @Valid CarreraRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarreraResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CarreraResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}