package com.uam.springboot.manager.app.controller.catalogos;

import jakarta.validation.Valid;
import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.CarreraRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.CarreraResponseDTO;
import com.uam.springboot.manager.app.service.impl.catalogos.CarreraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carreras")
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