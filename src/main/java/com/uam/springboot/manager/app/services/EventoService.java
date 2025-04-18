package com.uam.springboot.manager.app.services;

import com.uam.springboot.manager.app.entities.Evento;
import com.uam.springboot.manager.app.repositories.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    // Método para obtener todos los eventos
    public List<Evento> obtenerTodosLosEventos() {
        List<Evento> eventos = new ArrayList<>();
        eventoRepository.findAll().forEach(eventos::add);
        return eventos;
    }

    // Método para obtener un evento por ID
    public Optional<Evento> obtenerEventoPorId(Long id) {
        return eventoRepository.findById(id);
    }

    // Método para guardar un nuevo evento
    public Evento guardarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    // Método para eliminar un evento
    public void eliminarEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}
