package com.uam.springboot.manager.app.model.catalogos;


import com.uam.springboot.manager.app.model.Identifiable;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="grupo_asignatura")
public class Grupo extends Identifiable {

    @NotBlank
    private String codigo;

    @Min(1)
    @NotNull
    private Integer numeroEstudiantes;

    @OneToOne
    private Profesor profesor;

    @Min(1)
    @NotNull
    private Integer numeroGrupo;
}
