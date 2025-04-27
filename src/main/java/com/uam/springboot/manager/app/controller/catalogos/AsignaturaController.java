package com.uam.springboot.manager.app.controller.catalogos;

import jakarta.validation.Valid;
import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.AsignaturaRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.AsignaturaResponseDTO;
import com.uam.springboot.manager.app.service.impl.catalogos.AsignaturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
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