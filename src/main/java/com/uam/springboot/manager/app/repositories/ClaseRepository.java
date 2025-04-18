package com.uam.springboot.manager.app.repositories;

import com.uam.springboot.manager.app.entities.Clase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepository extends CrudRepository<Clase, Long> {
    boolean existsByCodigo(String codigo);
}
