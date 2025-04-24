package com.uam.springboot.manager.app.model.catalogos;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class EquipoAmbiente extends Identifiable{

    @NotBlank
    @Column(unique=true, nullable=false, length=12)
    private String codigo;

    @NotBlank
    private String descripcion;

    public @NotBlank String getCodigo() {
        return codigo;
    }

    public void setCodigo(@NotBlank String codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NotBlank String descripcion) {
        this.descripcion = descripcion;
    }
}
