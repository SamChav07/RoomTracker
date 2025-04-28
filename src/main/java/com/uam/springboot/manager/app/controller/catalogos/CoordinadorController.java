package com.uam.springboot.manager.app.controller.catalogos;

import jakarta.validation.Valid;
import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.CoordinadorRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.CoordinadorResponseDTO;
import com.uam.springboot.manager.app.service.impl.catalogos.CoordinadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coordinadores")
public class CoordinadorController {

    private final CoordinadorService service;

    public CoordinadorController(CoordinadorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CoordinadorResponseDTO> create(@RequestBody @Valid CoordinadorRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoordinadorResponseDTO> update(@PathVariable Long id, @RequestBody @Valid CoordinadorRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoordinadorResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CoordinadorResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
