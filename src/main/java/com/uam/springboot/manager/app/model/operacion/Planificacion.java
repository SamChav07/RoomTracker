package com.uam.springboot.manager.app.model.operacion;

import com.uam.springboot.manager.app.model.catalogos.Grupo;
import com.uam.springboot.manager.app.model.Identifiable;
import com.uam.springboot.manager.app.model.catalogos.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name="planificaciones")
@Getter
@Setter
public class Planificacion extends Identifiable {

    private LocalDateTime fechaEjecucion;

    @ManyToOne
    private Usuario responsable; // “Sistema” o usuario

    @Enumerated(EnumType.STRING)
    private ESTADOPLANIFICACION estadoPlan; // EN_CURSO, COMPLETADA

    @OneToMany(mappedBy="planificacion", cascade=ALL)
    private List<Reserva> reservas = new ArrayList<>();

}
