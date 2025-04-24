package com.uam.springboot.manager.app.controller.catalogos;

import jakarta.validation.Valid;
import com.uam.springboot.manager.app.dto.catalogos.BloqueHorarioRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.BloqueHorarioResponseDTO;
import com.uam.springboot.manager.app.service.impl.catalogos.BloqueHorarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bloques")
public class BloqueHorarioController {
    private final BloqueHorarioService service;

    public BloqueHorarioController(BloqueHorarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BloqueHorarioResponseDTO> create(@RequestBody @Valid BloqueHorarioRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BloqueHorarioResponseDTO> update(@PathVariable Long id, @RequestBody @Valid BloqueHorarioRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloqueHorarioResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<BloqueHorarioResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}