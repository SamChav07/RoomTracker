package com.uam.springboot.manager.app.repository.solicitud;

import com.uam.springboot.manager.app.model.solicitud.SolicitudItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudItemRepository extends JpaRepository<SolicitudItem, Long> {
}
