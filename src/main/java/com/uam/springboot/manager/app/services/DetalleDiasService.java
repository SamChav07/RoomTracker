package com.uam.springboot.manager.app.services;

import com.uam.springboot.manager.app.entities.DetalleDias;
import com.uam.springboot.manager.app.repositories.DetalleDiasRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleDiasService {

    private final DetalleDiasRepository detalleDiasRepository;

    public DetalleDiasService(DetalleDiasRepository detalleDiasRepository) {
        this.detalleDiasRepository = detalleDiasRepository;
    }

    public List<DetalleDias> findAll() {
        List<DetalleDias> detalles = new ArrayList<>();
        detalleDiasRepository.findAll().forEach(detalles::add);
        return detalles;
    }

    public Optional<DetalleDias> findById(Long id) {
        return detalleDiasRepository.findById(id);
    }

    public DetalleDias save(DetalleDias detalleDias) {
        return detalleDiasRepository.save(detalleDias);
    }

    public void delete(Long id) {
        detalleDiasRepository.deleteById(id);
    }
}
