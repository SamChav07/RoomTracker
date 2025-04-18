package com.uam.springboot.manager.app.repositories;

import com.uam.springboot.manager.app.entities.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Long> {
}
