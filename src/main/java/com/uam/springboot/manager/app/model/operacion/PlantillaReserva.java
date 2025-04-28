package com.uam.springboot.manager.app.model.operacion;

import com.uam.springboot.manager.app.model.catalogos.*;
import com.uam.springboot.manager.app.model.Identifiable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;

@Entity
@Table(name="plantillas_reserva")
@Getter
@Setter
public class PlantillaReserva extends Identifiable {
    @ManyToOne(optional=false)
    private PeriodoAcademico periodo;         // p.ej. “2025-1”

    @Enumerated(EnumType.STRING)
    private DIASSEMANA diaSemana;              // LUNES…DOMINGO

    @ManyToOne(optional=false)
    private Ambiente ambiente;

    @ManyToOne(optional=false)
    private BloqueHorario timeSlot;

    @ManyToOne(optional=false)
    private Grupo grupo;

}

