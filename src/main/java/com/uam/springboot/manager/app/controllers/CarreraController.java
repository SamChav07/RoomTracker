package com.uam.springboot.manager.app.controllers;

import com.uam.springboot.manager.app.entities.Carrera;
import com.uam.springboot.manager.app.services.CarreraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
public class CarreraController {

    private final CarreraService carreraService;

    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    @GetMapping
    public ResponseEntity<List<Carrera>> getAll() {
        return ResponseEntity.ok(carreraService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrera> getById(@PathVariable Long id) {
        return carreraService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carrera> create(@RequestBody Carrera carrera) {
        return ResponseEntity.ok(carreraService.save(carrera));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carreraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}