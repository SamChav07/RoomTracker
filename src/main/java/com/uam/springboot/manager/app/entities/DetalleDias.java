package com.uam.springboot.manager.app.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "detalle_dias")
public class DetalleDias extends Identifiable {

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Debe especificar el día")
    @Column(name = "dia", nullable = false)
    private DIA dia;

    @ManyToOne
    @JoinColumn(name = "detalle_solicitud_id")
    private DetalleSolicitud detalleSolicitud;
}