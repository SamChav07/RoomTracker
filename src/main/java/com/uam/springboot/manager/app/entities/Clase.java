package com.uam.springboot.manager.app.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("clase")
public class Clase extends Actividad {

    @Min(value = 1, message = "El grupo debe ser mayor o igual a 1")
    private int grupo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrera_id", nullable = false)
    @NotNull(message = "La carrera es obligatoria")
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id", nullable = false)
    @NotNull(message = "El profesor es obligatorio")
    private Profesor profesor;
}
