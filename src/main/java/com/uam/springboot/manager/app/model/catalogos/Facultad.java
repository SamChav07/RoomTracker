package com.uam.springboot.manager.app.model.catalogos;

import com.uam.springboot.manager.app.model.Identifiable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "facultad")
public class Facultad extends Identifiable {

    @NotBlank
    @Column(nullable = false, unique = true, length = 10)
    private String codigo;

    @NotBlank
    @Column(nullable = false, unique = true, length = 50)
    private String nombre;

}
