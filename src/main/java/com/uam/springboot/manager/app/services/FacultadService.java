package com.uam.springboot.manager.app.services;

import com.uam.springboot.manager.app.entities.Facultad;
import com.uam.springboot.manager.app.repositories.FacultadRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacultadService {

    private final FacultadRepository facultadRepository;

    public FacultadService(FacultadRepository facultadRepository) {
        this.facultadRepository = facultadRepository;
    }

    public List<Facultad> obtenerTodas() {
        List<Facultad> facultades = new ArrayList<>();
        facultadRepository.findAll().forEach(facultades::add);
        return facultades;
    }

    public Optional<Facultad> obtenerPorId(Long id) {
        return facultadRepository.findById(id);
    }

    public Facultad guardar(Facultad facultad) {
        if (facultadRepository.existsByNombreFacultad(facultad.getNombreFacultad())) {
            throw new IllegalArgumentException("Ya existe una facultad con ese nombre");
        }
        return facultadRepository.save(facultad);
    }

    public Facultad actualizar(Long id, Facultad facultadActualizada) {
        Facultad facultad = facultadRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("No se encontró la facultad con ID " + id));

        facultad.setNombreFacultad(facultadActualizada.getNombreFacultad());
        return facultadRepository.save(facultad);
    }

    public void eliminar(Long id) {
        facultadRepository.deleteById(id);
    }
}
