package com.uam.springboot.manager.app.controllers;

import com.uam.springboot.manager.app.entities.DetalleSolicitud;
import com.uam.springboot.manager.app.services.DetalleSolicitudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle-solicitud")
public class DetalleSolicitudController {

    private final DetalleSolicitudService detalleSolicitudService;

    public DetalleSolicitudController(DetalleSolicitudService detalleSolicitudService) {
        this.detalleSolicitudService = detalleSolicitudService;
    }

    @GetMapping
    public ResponseEntity<List<DetalleSolicitud>> getAll() {
        return ResponseEntity.ok(detalleSolicitudService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleSolicitud> getById(@PathVariable Long id) {
        return detalleSolicitudService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DetalleSolicitud> create(@RequestBody DetalleSolicitud detalleSolicitud) {
        return ResponseEntity.ok(detalleSolicitudService.save(detalleSolicitud));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        detalleSolicitudService.delete(id);
        return ResponseEntity.noContent().build();
    }
}