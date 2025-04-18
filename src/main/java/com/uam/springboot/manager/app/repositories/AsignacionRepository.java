package com.uam.springboot.manager.app.repositories;

import com.uam.springboot.manager.app.entities.Asignacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignacionRepository extends CrudRepository<Asignacion, Long> {
}
