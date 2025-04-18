package com.uam.springboot.manager.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "actividad")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipoActividad")
public abstract class Actividad extends Identifiable {
    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;
    private int tamanio;
    private int duracion;
}
// Esta es una clase abstracta