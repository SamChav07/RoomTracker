package com.uam.springboot.manager.app.controllers;

import com.uam.springboot.manager.app.entities.DetalleDias;
import com.uam.springboot.manager.app.services.DetalleDiasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle-dias")
public class DetalleDiasController {

    private final DetalleDiasService detalleDiasService;

    public DetalleDiasController(DetalleDiasService detalleDiasService) {
        this.detalleDiasService = detalleDiasService;
    }

    @GetMapping
    public ResponseEntity<List<DetalleDias>> getAll() {
        return ResponseEntity.ok(detalleDiasService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleDias> getById(@PathVariable Long id) {
        return detalleDiasService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DetalleDias> create(@RequestBody DetalleDias detalleDias) {
        return ResponseEntity.ok(detalleDiasService.save(detalleDias));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        detalleDiasService.delete(id);
        return ResponseEntity.noContent().build();
    }
}