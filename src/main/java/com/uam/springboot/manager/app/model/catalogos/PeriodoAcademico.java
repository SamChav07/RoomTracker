package com.uam.springboot.manager.app.model.catalogos;

import com.uam.springboot.manager.app.model.Identifiable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@Table(name = "periodo_academico")
public class PeriodoAcademico extends Identifiable {

    @Column(unique=true, nullable=false, length=12)
    private String codigo;

    @NotBlank
    private String descripcion;

    @NotNull
    private LocalDate fechaInicio;

    @NotNull
    private LocalDate fechaFin;

    @Min(1)
    private Integer semanasTotales;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TIPOSEMESTRE tiposemestre;

}
