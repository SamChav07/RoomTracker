package com.uam.springboot.manager.app.model.catalogos;


import com.uam.springboot.manager.app.model.Identifiable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class EquipoAmbiente extends Identifiable {

    @NotBlank
    @Column(unique=true, nullable=false, length=12)
    private String codigo;

    @NotBlank
    private String descripcion;

}
