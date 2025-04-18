package com.uam.springboot.manager.app.controllers;

import com.uam.springboot.manager.app.entities.Actividad;
import com.uam.springboot.manager.app.services.ActividadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actividades")
public class ActividadController {

    private final ActividadService actividadService;

    public ActividadController(ActividadService actividadService) {
        this.actividadService = actividadService;
    }

    @GetMapping
    public ResponseEntity<List<Actividad>> getAll() {
        return ResponseEntity.ok(actividadService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actividad> getById(@PathVariable Long id) {
        return actividadService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Actividad> create(@RequestBody Actividad actividad) {
        return ResponseEntity.ok(actividadService.save(actividad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        actividadService.delete(id);
        return ResponseEntity.noContent().build();
    }
}