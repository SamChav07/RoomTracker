package com.uam.springboot.manager.app.repositories;

import com.uam.springboot.manager.app.entities.Facultad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultadRepository extends CrudRepository<Facultad, Long> {
    boolean existsByNombreFacultad(String nombreFacultad);
}
