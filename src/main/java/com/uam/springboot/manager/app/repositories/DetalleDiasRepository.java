package com.uam.springboot.manager.app.repositories;

import com.uam.springboot.manager.app.entities.DetalleDias;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleDiasRepository extends CrudRepository<DetalleDias, Long> {
}
