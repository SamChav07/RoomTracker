package com.uam.springboot.manager.app.repository.operacion;

import com.uam.springboot.manager.app.model.catalogos.DIASSEMANA;
import com.uam.springboot.manager.app.model.operacion.PlantillaReserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantillaReservaRepository extends JpaRepository<PlantillaReserva, Long> {
    List<PlantillaReserva> findByPeriodoIdAndDiaSemana(Long periodoId, DIASSEMANA diaSemana);

}
