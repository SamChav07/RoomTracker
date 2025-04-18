package com.uam.springboot.manager.app.repositories;

import com.uam.springboot.manager.app.entities.Solicitud;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SolicitudRepository extends CrudRepository<Solicitud, Long> {
    List<Solicitud> findByFecha(LocalDate fecha);
    List<Solicitud> findBySolicitanteId(Long coordinadorId);
}
