package com.uam.springboot.manager.app.controllers;

import com.uam.springboot.manager.app.entities.Facultad;
import com.uam.springboot.manager.app.services.FacultadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facultades")
public class FacultadController {

    private final FacultadService facultadService;

    @Autowired
    public FacultadController(FacultadService facultadService) {
        this.facultadService = facultadService;
    }

    @GetMapping
    public List<Facultad> listar() {
        return facultadService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facultad> obtenerPorId(@PathVariable Long id) {
        return facultadService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Facultad> crear(@RequestBody Facultad facultad) {
        return ResponseEntity.ok(facultadService.guardar(facultad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Facultad> actualizar(@PathVariable Long id, @RequestBody Facultad facultad) {
        return ResponseEntity.ok(facultadService.actualizar(id, facultad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        facultadService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}