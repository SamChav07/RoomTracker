package com.uam.springboot.manager.app.model.solicitud;

import com.uam.springboot.manager.app.model.catalogos.Grupo;
import com.uam.springboot.manager.app.model.Identifiable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name="solicitud_items")
@Getter
@Setter
public class SolicitudItem extends Identifiable {

    @ManyToOne(optional=false)
    private Solicitud solicitud;

    @ManyToOne(optional=false)
    private Grupo grupo;

    @Enumerated(EnumType.STRING)
    private ESTADOITEM estadoItem;

    @OneToMany(mappedBy="solicitudItem", cascade=ALL, orphanRemoval=true)
    private List<TimeSlotPreference> preferencias = new ArrayList<>();
}
