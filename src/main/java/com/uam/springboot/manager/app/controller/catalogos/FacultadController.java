package com.uam.springboot.manager.app.controller.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.FacultadRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.FacultadResponseDTO;
import com.uam.springboot.manager.app.service.impl.catalogos.FacultadService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facultades")
public class FacultadController {

    public FacultadController(FacultadService service) {
        this.service = service;
    }

    private final FacultadService service;

    @PostMapping
    public ResponseEntity<FacultadResponseDTO> create(@RequestBody @Valid FacultadRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<FacultadResponseDTO> update(@PathVariable Long id, @RequestBody @Valid FacultadRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id); return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultadResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping public ResponseEntity<List<FacultadResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}