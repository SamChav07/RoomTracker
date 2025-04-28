package com.uam.springboot.manager.app.model.catalogos;

import com.uam.springboot.manager.app.model.Identifiable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import static jakarta.persistence.FetchType.EAGER;

@Entity
@Table(name="usuarios")
@Getter
@Setter
public class Usuario extends Identifiable {

    private String email;
    private String passwordHash;
    private String nombre;
    @ManyToMany(fetch=EAGER)
    @JoinTable(name = "usuario_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    )
    private Set<Rol> roles;
}
