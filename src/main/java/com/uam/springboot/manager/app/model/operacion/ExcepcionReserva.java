package com.uam.springboot.manager.app.model.operacion;

import com.uam.springboot.manager.app.model.Identifiable;
import com.uam.springboot.manager.app.model.catalogos.Ambiente;
import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import com.uam.springboot.manager.app.model.catalogos.Grupo;
import com.uam.springboot.manager.app.model.solicitud.SolicitudItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="excepciones_reserva")
@Getter
@Setter
public class ExcepcionReserva extends Identifiable {
    @ManyToOne(optional=false)
    private PlantillaReserva plantilla;       // de dónde proviene

    @Column(nullable=false)
    private LocalDate fecha;                  // fecha exacta de la excepción

    @Enumerated(EnumType.STRING)
    private TIPOEXCEPCION tipo;               // MODIFICACION, ANULACION

    // Sólo para MODIFICACION: valores que sobreescriben la plantilla
    @ManyToOne
    private Ambiente nuevoAmbiente;

    @ManyToOne
    private BloqueHorario nuevoTimeSlot;

    @ManyToOne
    private Grupo grupo;
}



