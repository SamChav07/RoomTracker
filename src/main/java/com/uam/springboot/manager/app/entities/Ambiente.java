package com.uam.springboot.manager.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ambiente")
public class Ambiente extends Identifiable {

    @Column(nullable = false, unique = true)
    private String codigo;

    @Enumerated(EnumType.STRING)
    private TIPOAMBIENTE tipoAmbiente;

    @Enumerated(EnumType.STRING)
    private ESTADOAMBIENTE estadoAmbiente;

    private int capacidad;

    public String getLabel() {
        return tipoAmbiente.name().replaceAll("_", " ") + "-" + codigo;
    }
}
