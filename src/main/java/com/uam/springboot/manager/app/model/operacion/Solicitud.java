package com.uam.springboot.manager.app.model.operacion;

import com.uam.springboot.manager.app.model.catalogos.Coordinador;
import com.uam.springboot.manager.app.model.Identifiable;
import com.uam.springboot.manager.app.model.catalogos.PeriodoAcademico;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name="solicitud")
@Getter
@Setter
public class Solicitud extends Identifiable {

    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private ESTADOSOLICITUD estado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "coordinador_id")
    private Coordinador coordinador;

    @ManyToOne(optional = false)
    @JoinColumn(name = "periodo_academico_id")
    private PeriodoAcademico periodoAcademico;

}
