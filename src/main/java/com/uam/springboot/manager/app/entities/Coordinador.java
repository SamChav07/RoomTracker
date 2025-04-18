package com.uam.springboot.manager.app.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("coordinador")
public class Coordinador extends Usuario{

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String email;
    private String telefono;

    @NonNull
    @OneToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    public Coordinador() {
        this.setRol(ROL.COORDINADOR);
    }

    @Override
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}
