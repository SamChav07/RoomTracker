package com.uam.springboot.manager.app.dto.solver;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class PlanificacionDiaDTO {
    private LocalDate fecha;
    private List<ReservaDTO> asignadas;
    private List<ReservaRechazadaDTO> rechazadas;
}


