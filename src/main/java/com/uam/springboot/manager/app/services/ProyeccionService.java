package com.uam.springboot.manager.app.services;

import com.uam.springboot.manager.app.entities.Proyeccion;
import com.uam.springboot.manager.app.repositories.ProyeccionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProyeccionService {

    private final ProyeccionRepository proyeccionRepository;

    public ProyeccionService(ProyeccionRepository proyeccionRepository) {
        this.proyeccionRepository = proyeccionRepository;
    }

    public List<Proyeccion> obtenerTodas() {
        List<Proyeccion> proyecciones = new ArrayList<>();
        proyeccionRepository.findAll().forEach(proyecciones::add);
        return proyecciones;
    }

    public Optional<Proyeccion> obtenerPorId(Long id) {
        return proyeccionRepository.findById(id);
    }

    public Proyeccion guardar(Proyeccion proyeccion) {
        if (proyeccionRepository.existsByFechaAndPlanificadorId(
                proyeccion.getFecha(), proyeccion.getPlanificador().getId())) {
            throw new IllegalArgumentException("Ya existe una proyección para esa fecha y planificador.");
        }
        return proyeccionRepository.save(proyeccion);
    }

    public Proyeccion actualizar(Long id, Proyeccion nueva) {
        Proyeccion proyeccion = proyeccionRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("No se encontró la proyección con ID " + id));
        proyeccion.setFecha(nueva.getFecha());
        proyeccion.setPlanificador(nueva.getPlanificador());
        proyeccion.setAsignaciones(nueva.getAsignaciones());
        return proyeccionRepository.save(proyeccion);
    }

    public void eliminar(Long id) {
        proyeccionRepository.deleteById(id);
    }
}