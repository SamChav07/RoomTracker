package com.uam.springboot.manager.app.repository.catalogos;

import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BloqueHorarioRepository extends JpaRepository<BloqueHorario, Long> {
    Optional<BloqueHorario> findByIndice(Integer indice);
}
