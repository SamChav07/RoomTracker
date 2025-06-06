package com.uam.springboot.manager.app.model.catalogos;


import com.uam.springboot.manager.app.model.Identifiable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Profesor extends Identifiable {

    @NotBlank
    private String nombre;

    @Email
    private String email;

    @NotNull
    private Boolean necesitaAccesibilidad;

}
