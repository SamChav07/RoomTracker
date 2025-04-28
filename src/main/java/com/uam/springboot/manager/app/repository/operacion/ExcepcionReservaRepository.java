package com.uam.springboot.manager.app.repository.operacion;

import com.uam.springboot.manager.app.model.operacion.ExcepcionReserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExcepcionReservaRepository extends JpaRepository<ExcepcionReserva, Long> {
    List<ExcepcionReserva> findByFecha(LocalDate fecha);
}
