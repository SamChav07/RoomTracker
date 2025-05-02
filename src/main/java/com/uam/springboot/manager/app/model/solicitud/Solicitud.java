package com.uam.springboot.manager.app.model.solicitud;

import com.uam.springboot.manager.app.model.catalogos.Coordinador;
import com.uam.springboot.manager.app.model.Identifiable;
import com.uam.springboot.manager.app.model.catalogos.PeriodoAcademico;
import com.uam.springboot.manager.app.model.catalogos.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "solicitud")
@Getter
@Setter
public class Solicitud extends Identifiable {
    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaSolicitud;

    @ManyToOne(optional = false)
    private Coordinador coordinador;

    @ManyToOne(optional = false)
    private PeriodoAcademico periodo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ESTADOSOLICITUD estado;  // PENDIENTE, EN_PROCESO, PROCESADA

    @OneToMany(mappedBy = "solicitud", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SolicitudItem> items = new ArrayList<>();

    @PrePersist
    protected void asignarValores() {
        this.fechaSolicitud = LocalDateTime.now();
        this.estado = ESTADOSOLICITUD.PENDIENTE;
    }

}
