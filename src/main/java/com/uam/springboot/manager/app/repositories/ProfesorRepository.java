package com.uam.springboot.manager.app.repositories;

import com.uam.springboot.manager.app.entities.Profesor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Long> {
    boolean existsByEmail(String email);
    boolean existsByCif(String cif);
}
