package com.uam.springboot.manager.app.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "detalle_solicitud")
public class DetalleSolicitud extends Identifiable {

    @NotNull(message = "La actividad es obligatoria")
    @ManyToOne
    @JoinColumn(name = "actividad_id", referencedColumnName = "id")
    private Actividad actividad;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Debe especificar el horario deseado")
    @Column(name = "horario_deseado", nullable = false)
    private HORARIO horarioDeseado;

    @ManyToOne
    @JoinColumn(name = "solicitud_id")
    private Solicitud solicitud;

    @OneToMany(mappedBy = "detalleSolicitud", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleDias> dias;
}
