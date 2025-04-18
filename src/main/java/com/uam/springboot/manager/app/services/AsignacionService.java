package com.uam.springboot.manager.app.services;

import com.uam.springboot.manager.app.entities.Asignacion;
import com.uam.springboot.manager.app.repositories.AsignacionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AsignacionService {

    private final AsignacionRepository asignacionRepository;

    public AsignacionService(AsignacionRepository asignacionRepository) {
        this.asignacionRepository = asignacionRepository;
    }

    public List<Asignacion> findAll() {
        List<Asignacion> asignaciones = new ArrayList<>();
        asignacionRepository.findAll().forEach(asignaciones::add);
        return asignaciones;
    }

    public Optional<Asignacion> findById(Long id) {
        return asignacionRepository.findById(id);
    }

    public Asignacion save(Asignacion asignacion) {
        return asignacionRepository.save(asignacion);
    }

    public void delete(Long id) {
        asignacionRepository.deleteById(id);
    }
}