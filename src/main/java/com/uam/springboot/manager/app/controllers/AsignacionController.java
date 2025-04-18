package com.uam.springboot.manager.app.controllers;

import com.uam.springboot.manager.app.entities.Asignacion;
import com.uam.springboot.manager.app.services.AsignacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionController {

    private final AsignacionService asignacionService;

    public AsignacionController(AsignacionService asignacionService) {
        this.asignacionService = asignacionService;
    }

    @GetMapping
    public ResponseEntity<List<Asignacion>> getAll() {
        return ResponseEntity.ok(asignacionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignacion> getById(@PathVariable Long id) {
        return asignacionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Asignacion> create(@RequestBody Asignacion asignacion) {
        return ResponseEntity.ok(asignacionService.save(asignacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        asignacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}