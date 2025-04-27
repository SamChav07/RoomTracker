package com.uam.springboot.manager.app.model.operacion;

import com.uam.springboot.manager.app.model.Identifiable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="conflictos")
@Getter
@Setter
public class Conflicto extends Identifiable {

    @ManyToOne
    private Reserva reservaA;

    @ManyToOne
    private Reserva reservaB;

    @Enumerated(EnumType.STRING)
    private TIPOCONFLICTO tipoConflicto;
}
