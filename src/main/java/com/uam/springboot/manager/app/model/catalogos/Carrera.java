package com.uam.springboot.manager.app.model.catalogos;


import com.uam.springboot.manager.app.model.Identifiable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Carrera extends Identifiable {

    @Column(unique=true, nullable=false, length=12)
    @NotBlank
    private String codigo;


    @Column(nullable = false, length = 80)
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "facultad_id")
    private Facultad facultad;

}

