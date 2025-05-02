package com.uam.springboot.manager.app.model.solicitud;

import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import com.uam.springboot.manager.app.model.catalogos.DIASSEMANA;
import com.uam.springboot.manager.app.model.catalogos.Grupo;
import com.uam.springboot.manager.app.model.Identifiable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "solicitud_items")
@Getter
@Setter
public class SolicitudItem extends Identifiable {
    @ManyToOne(optional = false)
    private Solicitud solicitud;

    @ElementCollection(targetClass = DIASSEMANA.class)
    @CollectionTable(name = "solicitud_item_dias", joinColumns = @JoinColumn(name = "item_id"))
    @Column(name = "dia_semana", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<DIASSEMANA> diasSemana;

    @ManyToOne(optional = false)
    private BloqueHorario bloqueInicio;    // primer bloque del intervalo continuo

    @Column(nullable = false)
    @Min(1)
    private Integer duracionBloques;       // número de bloques consecutivos

    @ManyToOne(optional = false)
    private Grupo grupo;

    @Column(nullable = false)
    @Min(1)
    private Integer numeroGrupos;          // cuántos grupos idénticos

    @Column(length = 500)
    private String observaciones;

}