package com.uam.springboot.manager.app.model.catalogos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Carrera extends Identifiable{

    @Column(unique=true, nullable=false, length=12)
    @NotBlank
    private String codigo;

    @NotBlank
    private String nombre;

}
