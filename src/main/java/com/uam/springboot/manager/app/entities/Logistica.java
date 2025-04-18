package com.uam.springboot.manager.app.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("logistica")
public class Logistica extends Usuario {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    @Email(message = "El email no tiene un formato válido")
    private String email;
    private String telefono;

    public Logistica() {
        this.setRol(ROL.LOGISTICA);
    }

    @Override
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}

