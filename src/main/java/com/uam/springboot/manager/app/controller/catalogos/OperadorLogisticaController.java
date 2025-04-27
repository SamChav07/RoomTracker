package com.uam.springboot.manager.app.controller.catalogos;

import jakarta.validation.Valid;
import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.OperadorLogisticaRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.OperadorLogisticaResponseDTO;
import com.uam.springboot.manager.app.service.impl.catalogos.OperadorLogisticaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operadores-logistica")
public class OperadorLogisticaController {

    private final OperadorLogisticaService service;

    public OperadorLogisticaController(OperadorLogisticaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OperadorLogisticaResponseDTO> create(@RequestBody @Valid OperadorLogisticaRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OperadorLogisticaResponseDTO> update(@PathVariable Long id, @RequestBody @Valid OperadorLogisticaRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperadorLogisticaResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<OperadorLogisticaResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
