package com.uam.springboot.manager.app.model.solicitud;

import com.uam.springboot.manager.app.model.catalogos.Coordinador;
import com.uam.springboot.manager.app.model.Identifiable;
import com.uam.springboot.manager.app.model.catalogos.PeriodoAcademico;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
