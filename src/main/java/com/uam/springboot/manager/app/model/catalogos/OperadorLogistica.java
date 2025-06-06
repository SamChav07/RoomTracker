package com.uam.springboot.manager.app.model.catalogos;

import com.uam.springboot.manager.app.model.Identifiable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="operador_logistica")
public class OperadorLogistica extends Identifiable {
    @OneToOne
    @JoinColumn(name="usuario_id", unique=true)
    private Usuario usuario;
    // aquí podrías añadir campos propios de logística, p.ej. centroResponsable, turnos, etc.
}
