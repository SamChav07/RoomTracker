package com.uam.springboot.manager.app.services;

import com.uam.springboot.manager.app.entities.Profesor;
import com.uam.springboot.manager.app.repositories.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public List<Profesor> obtenerTodos() {
        List<Profesor> profesores = new ArrayList<>();
        profesorRepository.findAll().forEach(profesores::add);
        return profesores;
    }

    public Optional<Profesor> obtenerPorId(Long id) {
        return profesorRepository.findById(id);
    }

    public Profesor guardar(Profesor profesor) {
        if (profesorRepository.existsByEmail(profesor.getEmail())) {
            throw new IllegalArgumentException("Ya existe un profesor con ese email.");
        }
        if (profesorRepository.existsByCif(profesor.getCif())) {
            throw new IllegalArgumentException("Ya existe un profesor con ese CIF.");
        }
        return profesorRepository.save(profesor);
    }

    public Profesor actualizar(Long id, Profesor actualizado) {
        Profesor profesor = profesorRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Profesor no encontrado"));

        profesor.setNombreCompleto(actualizado.getNombreCompleto());
        profesor.setEmail(actualizado.getEmail());
        profesor.setCif(actualizado.getCif());

        return profesorRepository.save(profesor);
    }

    public void eliminar(Long id) {
        profesorRepository.deleteById(id);
    }
}
