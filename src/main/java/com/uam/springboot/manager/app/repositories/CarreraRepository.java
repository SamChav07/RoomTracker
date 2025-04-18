package com.uam.springboot.manager.app.repositories;

import com.uam.springboot.manager.app.entities.Carrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Long> {
}
