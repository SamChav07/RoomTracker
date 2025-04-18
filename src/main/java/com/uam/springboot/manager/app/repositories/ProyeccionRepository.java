package com.uam.springboot.manager.app.repositories;

import com.uam.springboot.manager.app.entities.Proyeccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyeccionRepository extends CrudRepository<Proyeccion, Long> {
    boolean existsByFechaAndPlanificadorId(java.time.LocalDate fecha, Long planificadorId);
}
