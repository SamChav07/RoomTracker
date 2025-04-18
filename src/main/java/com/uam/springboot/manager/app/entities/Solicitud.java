package com.uam.springboot.manager.app.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="solicitud")

public class Solicitud extends Identifiable {

    @NotNull(message = "La fecha de la solicitud es obligatoria")
    @Column(nullable = false)
    private LocalDate fecha;

    @NotNull(message = "Debe haber un coordinador solicitante")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coordinador_id")
    private Coordinador solicitante;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Debe especificar el tipo de solicitud")
    @Column(nullable = false)
    private TIPOSOLICITUD tipoSolicitud;

    @OneToMany(mappedBy = "solicitud", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleSolicitud> detalleSolicitud;

    // Opcional: puedes añadir un método de utilidad si lo necesitas
    public boolean esSolicitudSemestral() {
        return TIPOSOLICITUD.SEMESTRE.equals(tipoSolicitud);
    }
}
