package com.uam.springboot.manager.app.model.solicitud;

import com.uam.springboot.manager.app.model.Identifiable;
import com.uam.springboot.manager.app.model.catalogos.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="ajustes_manuales")
@Getter
@Setter
public class AjusteManual extends Identifiable {

    @ManyToOne(optional=false)
    private Usuario usuario; // operador

    private LocalDateTime fecha;

    @Column(length=200)
    private String comentario;
}
