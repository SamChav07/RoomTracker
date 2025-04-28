package com.uam.springboot.manager.app.controller.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.GrupoRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.GrupoResponseDTO;
import com.uam.springboot.manager.app.service.impl.catalogos.GrupoService;
import com.uam.springboot.manager.app.service.impl.catalogos.GrupoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {
    
    public GrupoController(GrupoService service) {
        this.service = service;
    }

    private final GrupoService service;

    @PostMapping
    public ResponseEntity<GrupoResponseDTO> create(@RequestBody @Valid GrupoRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GrupoResponseDTO> update(@PathVariable Long id, @RequestBody @Valid GrupoRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id); return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping public ResponseEntity<List<GrupoResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
