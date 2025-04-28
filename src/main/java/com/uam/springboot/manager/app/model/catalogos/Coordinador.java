package com.uam.springboot.manager.app.model.catalogos;

import com.uam.springboot.manager.app.model.Identifiable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="coordinador")
@Getter
@Setter
public class Coordinador extends Identifiable {

    @OneToOne
    @MapsId
    @JoinColumn(name="id")
    private Usuario usuario;

    @OneToOne(optional=false)
    @JoinColumn(name="carrera_id")
    private Carrera carreraCordinada;
}
