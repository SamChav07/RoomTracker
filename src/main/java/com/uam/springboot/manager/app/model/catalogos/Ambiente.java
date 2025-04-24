package com.uam.springboot.manager.app.model.catalogos;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Ambiente extends Identifiable{

    @NotBlank
    @Column(unique = true)
    private String codigo;

    @Min(1)
    private Integer capacidad;

    @NotNull
    private Boolean accesible;

    @Enumerated(EnumType.STRING)
    private ESTADOAMBIENTE estado;

    @Enumerated(EnumType.STRING)
    private TIPOAMBIENTE tipoAmbiente;

    @ManyToMany
    @JoinTable(name="ambiente_equipo",
                joinColumns = @JoinColumn(name="ambiente_id"),
                inverseJoinColumns = @JoinColumn(name="equipo_id"))
    private Set<EquipoAmbiente> equipos;

}
