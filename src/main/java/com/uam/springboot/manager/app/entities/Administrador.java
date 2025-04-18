package com.uam.springboot.manager.app.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("administrador")
public class Administrador extends Usuario {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    private String email;
    private String telefono;

    public Administrador() {
        this.setRol(ROL.ADMINISTRADOR);
    }

    @Override
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}
