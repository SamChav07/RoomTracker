package com.uam.springboot.manager.app.model.operacion;

import com.uam.springboot.manager.app.model.catalogos.Ambiente;
import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import com.uam.springboot.manager.app.model.Identifiable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="reservas")
@Getter
@Setter
public class Reserva extends Identifiable {

    @ManyToOne(optional=false)
    private SolicitudItem solicitudItem;

    @ManyToOne(optional=false)
    private Ambiente ambiente;

    @ManyToOne(optional=false)
    private BloqueHorario timeSlot;

    @Enumerated(EnumType.STRING)
    private ORIGENRESERVA origen; // PLANNER, MANUAL

    @Enumerated(EnumType.STRING)
    private ESTADORESERVA estadoReserva;

    @ManyToOne
    private Planificacion planificacion;
}

