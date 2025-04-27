package com.uam.springboot.manager.app.repository.catalogos;

import com.uam.springboot.manager.app.model.catalogos.Ambiente;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmbienteRepository extends JpaRepository<Ambiente, Long> {

}
