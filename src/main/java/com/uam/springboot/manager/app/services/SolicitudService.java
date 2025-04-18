package com.uam.springboot.manager.app.services;

import com.uam.springboot.manager.app.entities.Solicitud;
import com.uam.springboot.manager.app.repositories.SolicitudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;

    public SolicitudService(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    public List<Solicitud> obtenerTodas() {
        List<Solicitud> solicitudes = new ArrayList<>();
        solicitudRepository.findAll().forEach(solicitudes::add);
        return solicitudes;
    }

    public Optional<Solicitud> obtenerPorId(Long id) {
        return solicitudRepository.findById(id);
    }

    public List<Solicitud> obtenerPorCoordinador(Long coordinadorId) {
        return solicitudRepository.findBySolicitanteId(coordinadorId);
    }

    public Solicitud guardar(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    public Solicitud actualizar(Long id, Solicitud actualizada) {
        Solicitud existente = solicitudRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Solicitud no encontrada"));

        existente.setFecha(actualizada.getFecha());
        existente.setSolicitante(actualizada.getSolicitante());
        existente.setTipoSolicitud(actualizada.getTipoSolicitud());
        existente.setDetalleSolicitud(actualizada.getDetalleSolicitud());

        return solicitudRepository.save(existente);
    }

    public void eliminar(Long id) {
        solicitudRepository.deleteById(id);
    }
}
