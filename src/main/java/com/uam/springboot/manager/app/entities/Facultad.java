package com.uam.springboot.manager.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="facultad")
public class Facultad extends Identifiable {

    @NotBlank(message = "El nombre de la facultad no puede estar vacío")
    @Column(nullable = false, unique = true)
    private String nombreFacultad;

    @Override
    public String toString() {
        return nombreFacultad;
    }
}

