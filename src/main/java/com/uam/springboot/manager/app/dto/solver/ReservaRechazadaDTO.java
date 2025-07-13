package com.uam.springboot.manager.app.dto.solver;

import com.uam.springboot.manager.app.model.catalogos.DIASSEMANA;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservaRechazadaDTO {
    private String grupoCodigo;
    private String asignatura;
    private DIASSEMANA diaSemana;
    private Integer duracionBloques;
    private String motivo;   // «Capacidad insuficiente», «Faltan equipos requeridos», etc.
}

