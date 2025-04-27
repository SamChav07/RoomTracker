package com.uam.springboot.manager.app.controller.catalogos;

import jakarta.validation.Valid;
import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.PeriodoAcademicoRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.PeriodoAcademicoResponseDTO;
import com.uam.springboot.manager.app.service.impl.catalogos.PeriodoAcademicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/periodos")
public class PeriodoAcademicoController {
    private final PeriodoAcademicoService service;

    public PeriodoAcademicoController(PeriodoAcademicoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PeriodoAcademicoResponseDTO> create(@RequestBody @Valid PeriodoAcademicoRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeriodoAcademicoResponseDTO> update(@PathVariable Long id, @RequestBody @Valid PeriodoAcademicoRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodoAcademicoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PeriodoAcademicoResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}