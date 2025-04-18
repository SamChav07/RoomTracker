package com.uam.springboot.manager.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="profesor")
public class Profesor extends Identifiable {

    @NotBlank(message = "El nombre completo es obligatorio")
    @Column(nullable = false)
    private String nombreCompleto;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no tiene un formato válido")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "El CIF es obligatorio")
    @Column(nullable = false, unique = true, length = 15)
    private String cif;

    @Override
    public String toString() {
        return nombreCompleto + " - " + email;
    }
}
