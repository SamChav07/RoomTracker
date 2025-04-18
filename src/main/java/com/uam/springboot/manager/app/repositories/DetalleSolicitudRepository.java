package com.uam.springboot.manager.app.repositories;

import com.uam.springboot.manager.app.entities.DetalleSolicitud;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleSolicitudRepository extends CrudRepository<DetalleSolicitud, Long> {
}
