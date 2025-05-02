package com.uam.springboot.manager.app.model.solver;

import com.uam.springboot.manager.app.model.catalogos.Ambiente;
import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import lombok.Getter;
import lombok.Setter;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

@PlanningSolution
@Getter
@Setter
public class PlanificacionDiariaSolver {

    @PlanningId
    private Long id;

    @ProblemFactCollectionProperty
    private List<Ambiente> ambientes;

    @ProblemFactCollectionProperty
    private List<BloqueHorario> bloques;

    @PlanningEntityCollectionProperty
    private List<ReservaTentativa> reservas;

    @PlanningScore
    private HardSoftScore score;

    public PlanificacionDiariaSolver() {
    }

    public PlanificacionDiariaSolver(List<Ambiente> ambientes,
                                     List<BloqueHorario> bloques,
                                     List<ReservaTentativa> reservas) {
        this.ambientes = ambientes;
        this.bloques = bloques;
        this.reservas = reservas;
    }

    @ValueRangeProvider(id = "ambienteRange")
    public List<Ambiente> getAmbienteRange() {
        return ambientes;
    }

    @ValueRangeProvider(id = "bloqueRange")
    public List<BloqueHorario> getBloqueRange() {
        return bloques;
    }
}
