package com.uam.springboot.manager.app.services;

import com.uam.springboot.manager.app.entities.Carrera;
import com.uam.springboot.manager.app.repositories.CarreraRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarreraService {

    private final CarreraRepository carreraRepository;

    public CarreraService(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }

    public List<Carrera> findAll() {
        List<Carrera> carreras = new ArrayList<>();
        carreraRepository.findAll().forEach(carreras::add);
        return carreras;
    }

    public Optional<Carrera> findById(Long id) {
        return carreraRepository.findById(id);
    }

    public Carrera save(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    public void delete(Long id) {
        carreraRepository.deleteById(id);
    }
}