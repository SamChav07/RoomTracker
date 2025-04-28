package com.uam.springboot.manager.app.controller.catalogos;

import jakarta.validation.Valid;
import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.RolRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.RolResponseDTO;
import com.uam.springboot.manager.app.service.impl.catalogos.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    private final RolService service;

    public RolController(RolService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RolResponseDTO> create(@RequestBody @Valid RolRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolResponseDTO> update(@PathVariable Long id, @RequestBody @Valid RolRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<RolResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}

