package com.uam.springboot.manager.app.services;

import com.uam.springboot.manager.app.entities.Clase;
import com.uam.springboot.manager.app.repositories.ClaseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClaseService {

    private final ClaseRepository claseRepository;

    public ClaseService(ClaseRepository claseRepository) {
        this.claseRepository = claseRepository;
    }

    public List<Clase> findAll() {
        List<Clase> clases = new ArrayList<>();
        claseRepository.findAll().forEach(clases::add);
        return clases;
    }

    public Optional<Clase> findById(Long id) {
        return claseRepository.findById(id);
    }

    public Clase save(Clase clase) {
        if (claseRepository.existsByCodigo(clase.getCodigo())) {
            throw new IllegalArgumentException("Ya existe una clase con el código: " + clase.getCodigo());
        }
        return claseRepository.save(clase);
    }

    public void delete(Long id) {
        claseRepository.deleteById(id);
    }
}
