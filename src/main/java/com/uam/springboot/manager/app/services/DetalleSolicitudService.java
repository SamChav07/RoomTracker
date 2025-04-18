package com.uam.springboot.manager.app.services;

import com.uam.springboot.manager.app.entities.DetalleSolicitud;
import com.uam.springboot.manager.app.repositories.DetalleSolicitudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleSolicitudService {

    private final DetalleSolicitudRepository detalleSolicitudRepository;

    public DetalleSolicitudService(DetalleSolicitudRepository detalleSolicitudRepository) {
        this.detalleSolicitudRepository = detalleSolicitudRepository;
    }

    public List<DetalleSolicitud> findAll() {
        List<DetalleSolicitud> detalles = new ArrayList<>();
        detalleSolicitudRepository.findAll().forEach(detalles::add);
        return detalles;
    }

    public Optional<DetalleSolicitud> findById(Long id) {
        return detalleSolicitudRepository.findById(id);
    }

    public DetalleSolicitud save(DetalleSolicitud detalleSolicitud) {
        return detalleSolicitudRepository.save(detalleSolicitud);
    }

    public void delete(Long id) {
        detalleSolicitudRepository.deleteById(id);
    }
}
