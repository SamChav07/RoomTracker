package com.uam.springboot.manager.app.repository.solicitud;

import com.uam.springboot.manager.app.model.solicitud.Solicitud;
import com.uam.springboot.manager.app.model.solicitud.SolicitudItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudItemRepository extends JpaRepository<SolicitudItem, Long> {

    List<SolicitudItem> findBySolicitud(Solicitud solicitud);

}
