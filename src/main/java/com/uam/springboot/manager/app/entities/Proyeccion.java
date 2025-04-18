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
@Table(name="proyeccion")
public class Proyeccion extends Identifiable{

    @NotNull(message = "La fecha no puede ser nula")
    @Column(nullable = false)
    private LocalDate fecha;

    @NotNull(message = "Debe asignarse un planificador")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planificador_id")
    private Logistica planificador;

    @OneToMany(mappedBy = "proyeccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asignacion> asignaciones;

}
