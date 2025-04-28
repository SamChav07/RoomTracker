package com.uam.springboot.manager.app.repository.solicitud;

import com.uam.springboot.manager.app.model.solicitud.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
}
