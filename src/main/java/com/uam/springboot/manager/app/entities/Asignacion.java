package com.uam.springboot.manager.app.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="asignacion")
public class Asignacion extends Identifiable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ambiente_id", referencedColumnName = "id")
    @NotNull(message = "El ambiente no puede ser nulo")
    private Ambiente ambiente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actividad_id", referencedColumnName = "id")
    @NotNull(message = "La actividad no puede ser nula")
    private Actividad actividad;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El horario no puede ser nulo")
    private HORARIO horario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proyeccion_id")
    private Proyeccion proyeccion;

    @PrePersist
    @PreUpdate
    public void validarCapacidadAmbiente() {
        if (ambiente != null && actividad != null && ambiente.getCapacidad() < actividad.getTamanio()) {
            throw new IllegalArgumentException("El ambiente seleccionado no tiene capacidad suficiente para la actividad.");
        }
    }
}