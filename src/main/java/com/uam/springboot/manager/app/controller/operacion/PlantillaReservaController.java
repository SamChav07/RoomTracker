package com.uam.springboot.manager.app.controller.operacion;

import com.uam.springboot.manager.app.dto.operacion.requestDTOs.PlantillaReservaRequestDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.PlantillaReservaResponseDTO;
import com.uam.springboot.manager.app.model.catalogos.DIASSEMANA;
import com.uam.springboot.manager.app.service.impl.operacion.PlantillaReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plantillas")
public class PlantillaReservaController {

    private final PlantillaReservaService service;

    public PlantillaReservaController(PlantillaReservaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PlantillaReservaResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantillaReservaResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PlantillaReservaResponseDTO> create(
            @RequestBody PlantillaReservaRequestDTO dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlantillaReservaResponseDTO> update(
            @PathVariable Long id,
            @RequestBody PlantillaReservaRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/periodo/{periodoId}/dia/{diaSemana}")
    public ResponseEntity<List<PlantillaReservaResponseDTO>> findByPeriodoAndDia(
            @PathVariable Long periodoId,
            @PathVariable DIASSEMANA diaSemana) {
        return ResponseEntity.ok(service.findByPeriodoAndDia(periodoId, diaSemana));
    }
}