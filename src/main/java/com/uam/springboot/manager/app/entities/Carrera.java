package com.uam.springboot.manager.app.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="carrera")
public class Carrera extends Identifiable {

    @NotBlank(message = "El nombre de la carrera no puede estar vacío")
    @Column(nullable = false, unique = true)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facultad_id", nullable = false)
    private Facultad facultad;

    @Override
    public String toString() {
        return nombre + " (" + facultad.getNombreFacultad() + ")";
    }
}
