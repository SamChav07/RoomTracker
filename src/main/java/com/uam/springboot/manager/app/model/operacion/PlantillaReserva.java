package com.uam.springboot.manager.app.model.operacion;

import com.uam.springboot.manager.app.model.catalogos.*;
import com.uam.springboot.manager.app.model.Identifiable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.DayOfWeek;

@Entity
@Table(name="plantillas_reserva")
@Getter
@Setter
@ToString
public class PlantillaReserva extends Identifiable {
    @ManyToOne(optional=false)
    private PeriodoAcademico periodo;         // p.ej. “2025-1”

    @Enumerated(EnumType.STRING)
    @NotNull
    private DIASSEMANA diaSemana;              // LUNES…DOMINGO

    @ManyToOne(optional=false)
    @NotNull
    private Ambiente ambiente;

    @ManyToOne(optional=false)
    @NotNull
    private BloqueHorario timeSlot;

    @ManyToOne(optional=false)
    @NotNull
    private Grupo grupo;

}

