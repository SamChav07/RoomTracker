package com.uam.springboot.manager.app.controller.operacion;

import com.uam.springboot.manager.app.dto.operacion.requestDTOs.ExcepcionReservaRequestDTO;
import com.uam.springboot.manager.app.dto.operacion.responseDTOs.ExcepcionReservaResponseDTO;
import com.uam.springboot.manager.app.service.impl.operacion.ExcepcionReservaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/excepciones")
public class ExcepcionReservaController {

    private final ExcepcionReservaService service;

    public ExcepcionReservaController(ExcepcionReservaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ExcepcionReservaResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExcepcionReservaResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ExcepcionReservaResponseDTO> create(
            @RequestBody ExcepcionReservaRequestDTO dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExcepcionReservaResponseDTO> update(
            @PathVariable Long id,
            @RequestBody ExcepcionReservaRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<ExcepcionReservaResponseDTO>> findByFecha(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ResponseEntity.ok(service.findByFecha(fecha));
    }
}
