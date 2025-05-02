package com.uam.springboot.manager.app.model.solver;

import com.uam.springboot.manager.app.model.catalogos.Ambiente;
import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import com.uam.springboot.manager.app.model.catalogos.DIASSEMANA;
import com.uam.springboot.manager.app.model.catalogos.Grupo;
import lombok.Getter;
import lombok.Setter;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
@Getter
@Setter
public class ReservaTentativa {

    @PlanningId
    private Long id;

    private Grupo grupo;
    private DIASSEMANA diaSemana;
    private Integer duracionBloques;

    @PlanningVariable(valueRangeProviderRefs = "ambienteRange", nullable = true)
    private Ambiente ambiente;

    @PlanningVariable(valueRangeProviderRefs = "bloqueRange", nullable = true)
    private BloqueHorario bloqueInicio;

    // nuevo campo de prioridad: 1 = más antiguo, valores mayores = más reciente
    private int priority;

    public ReservaTentativa() {
    }

    public ReservaTentativa(Long id,
                            Grupo grupo,
                            DIASSEMANA diaSemana,
                            BloqueHorario bloqueInicio,
                            Integer duracionBloques,
                            int priority) {
        this.id = id;
        this.grupo = grupo;
        this.diaSemana = diaSemana;
        this.bloqueInicio = bloqueInicio;
        this.duracionBloques = duracionBloques;
        this.priority = priority;
    }

}