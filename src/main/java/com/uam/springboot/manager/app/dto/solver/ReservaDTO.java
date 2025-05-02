package com.uam.springboot.manager.app.dto.solver;

import com.uam.springboot.manager.app.model.catalogos.DIASSEMANA;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservaDTO {
    private String grupoCodigo;
    private String asignaturaNombre;
    private DIASSEMANA diaSemana;
    private Integer duracionBloques;
    // Para asignadas:
    private String ambienteCodigo;       // null si rechazada
    private Integer bloqueIndice;        // null si rechazada

    public ReservaDTO() {}

    public ReservaDTO(String grupoCodigo, String asignaturaNombre, DIASSEMANA diassemana,
                      Integer duracionBloques, String ambienteCodigo, Integer bloqueIndice) {

        this.grupoCodigo = grupoCodigo;
        this.asignaturaNombre = asignaturaNombre;
        this.diaSemana = diassemana;
        this.duracionBloques = duracionBloques;
        this.ambienteCodigo = ambienteCodigo;
        this.bloqueIndice = bloqueIndice;
    }
}