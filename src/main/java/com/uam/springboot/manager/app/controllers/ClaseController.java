package com.uam.springboot.manager.app.controllers;

import com.uam.springboot.manager.app.entities.Clase;
import com.uam.springboot.manager.app.services.ClaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {

    private final ClaseService claseService;

    public ClaseController(ClaseService claseService) {
        this.claseService = claseService;
    }

    @GetMapping
    public ResponseEntity<List<Clase>> getAll() {
        return ResponseEntity.ok(claseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clase> getById(@PathVariable Long id) {
        return claseService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Clase> create(@RequestBody Clase clase) {
        return ResponseEntity.ok(claseService.save(clase));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        claseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}