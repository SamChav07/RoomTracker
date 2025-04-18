package com.uam.springboot.manager.app.controllers;

import com.uam.springboot.manager.app.entities.Proyeccion;
import com.uam.springboot.manager.app.services.ProyeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecciones")
public class ProyeccionController {

    private final ProyeccionService proyeccionService;

    @Autowired
    public ProyeccionController(ProyeccionService proyeccionService) {
        this.proyeccionService = proyeccionService;
    }

    @GetMapping
    public List<Proyeccion> listar() {
        return proyeccionService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyeccion> obtener(@PathVariable Long id) {
        return proyeccionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Proyeccion> crear(@RequestBody Proyeccion proyeccion) {
        return ResponseEntity.ok(proyeccionService.guardar(proyeccion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyeccion> actualizar(@PathVariable Long id, @RequestBody Proyeccion proyeccion) {
        return ResponseEntity.ok(proyeccionService.actualizar(id, proyeccion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        proyeccionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
