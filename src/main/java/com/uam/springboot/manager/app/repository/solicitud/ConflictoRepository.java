package com.uam.springboot.manager.app.repository.solicitud;

import com.uam.springboot.manager.app.model.solicitud.Conflicto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConflictoRepository extends JpaRepository<Conflicto, Long> {
}
