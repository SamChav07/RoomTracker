package com.uam.springboot.manager.app.services;

import com.uam.springboot.manager.app.entities.Actividad;
import com.uam.springboot.manager.app.repositories.ActividadRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActividadService {

    private final ActividadRepository actividadRepository;

    public ActividadService(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    public List<Actividad> findAll() {
        List<Actividad> actividades = new ArrayList<>();
        actividadRepository.findAll().forEach(actividades::add);
        return actividades;
    }

    public Optional<Actividad> findById(Long id) {
        return actividadRepository.findById(id);
    }

    public Actividad save(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    public void delete(Long id) {
        actividadRepository.deleteById(id);
    }
}
