package com.uam.springboot.manager.app.repository.solicitud;

import com.uam.springboot.manager.app.model.solicitud.ESTADOSOLICITUD;
import com.uam.springboot.manager.app.model.solicitud.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

    List<Solicitud> findAllByEstado (ESTADOSOLICITUD estado);

}
