package com.uam.springboot.manager.app.model.catalogos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter
public class PeriodoAcademico extends Identifiable{

    @Column(unique=true, nullable=false, length=12)
    private String codigo;

    @NotNull
    private LocalDate fechaInicio;

    @NotNull
    private LocalDate fechaFin;

    @Min(1)
    private Integer semanasTotales;

}
