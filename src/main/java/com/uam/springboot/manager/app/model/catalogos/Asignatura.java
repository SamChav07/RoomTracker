package com.uam.springboot.manager.app.model.catalogos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
public class Asignatura extends Identifiable {

    @NotBlank
    @Column(unique=true, nullable=false, length=12)
    private String codigo;

    @NotBlank
    @Column(length = 80, nullable=false)
    private String nombre;

    @Min(1)
    private Integer capacidadSugerida;

    @ManyToMany
    @JoinTable(name="asignatura_equipo",
            joinColumns = @JoinColumn(name="asignatura_id"),
            inverseJoinColumns = @JoinColumn(name="equipo_id"))
    private Set<EquipoAmbiente> equiposNecesarios;

}
