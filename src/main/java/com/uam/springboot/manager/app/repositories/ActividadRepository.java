package com.uam.springboot.manager.app.repositories;

import com.uam.springboot.manager.app.entities.Actividad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadRepository extends CrudRepository<Actividad, Long> {
    boolean existsByCodigo(String codigo);
}
