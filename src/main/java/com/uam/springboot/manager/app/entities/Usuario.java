package com.uam.springboot.manager.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="tipoUsuario")
public abstract class Usuario extends Identifiable {

    private String usuario;
    private String password;

    @Enumerated(EnumType.STRING)
    private ROL rol;

    public abstract String getNombreCompleto();

    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
