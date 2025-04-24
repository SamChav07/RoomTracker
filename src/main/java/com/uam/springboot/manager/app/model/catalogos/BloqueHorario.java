package com.uam.springboot.manager.app.model.catalogos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
public class BloqueHorario extends Identifiable{

    @Enumerated(EnumType.STRING)
    private DIASSEMANA dia;

    @NotNull
    private LocalTime horaInicio;

    @NotNull
    private LocalTime horaFin;

    @Min(1)
    private Integer duracionMin;


}
