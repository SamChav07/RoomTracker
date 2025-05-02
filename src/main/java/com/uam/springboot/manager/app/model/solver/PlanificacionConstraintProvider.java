package com.uam.springboot.manager.app.model.solver;

import com.uam.springboot.manager.app.model.catalogos.Profesor;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import static org.optaplanner.core.api.score.stream.Joiners.equal;
import static org.optaplanner.core.api.score.stream.Joiners.lessThan;
import static org.optaplanner.core.api.score.stream.Joiners.*;


public class PlanificacionConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory factory) {
        return new Constraint[] {
                conflictoDeAula(factory),
                capacidadSuficiente(factory),
                equiposRequeridos(factory),
                accesibilidad(factory),
                maxReservasAsignadas(factory)
        };
    }

    private Constraint conflictoDeAula(ConstraintFactory factory) {
        return factory.forEach(ReservaTentativa.class)
                .filter(r -> r.getAmbiente() != null && r.getBloqueInicio() != null)
                .join(ReservaTentativa.class,
                        equal(ReservaTentativa::getAmbiente),
                        equal(ReservaTentativa::getDiaSemana),
                        lessThan(ReservaTentativa::getId),             // 1️⃣ indexable
                        filtering(OverlapHelper::isOverlapping)        // 2️⃣ no indexable
                )
                .penalize(HardSoftScore.ONE_HARD, (r1, r2) -> 1)
                .asConstraint("Conflicto de aula/horario");
    }

    // 2) Capacidad suficiente
    private Constraint capacidadSuficiente(ConstraintFactory factory) {
        return factory.forEach(ReservaTentativa.class)
                .filter(r -> r.getAmbiente() != null
                        && r.getAmbiente().getCapacidad()
                        < r.getGrupo().getNumeroEstudiantes())
                .penalize(HardSoftScore.ONE_HARD, r -> 1)
                .asConstraint("Insuficiente capacidad");
    }

    // 3) Equipos requeridos por la asignatura
    private Constraint equiposRequeridos(ConstraintFactory factory) {
        return factory.forEach(ReservaTentativa.class)
                .filter(r -> {
                    if (r.getAmbiente() == null) return false;
                    return !r.getAmbiente().getEquiposAmbiente()
                            .containsAll(r.getGrupo().getAsignatura().getEquiposNecesarios());
                })
                .penalize(HardSoftScore.ONE_HARD, r -> 1)
                .asConstraint("Faltan equipos requeridos");
    }

    // 4) Accesibilidad para el profesor
    private Constraint accesibilidad(ConstraintFactory factory) {
        return factory.forEach(ReservaTentativa.class)
                .filter(r -> {
                    Profesor prof = r.getGrupo().getProfesor();
                    return prof != null
                            && Boolean.TRUE.equals(prof.getNecesitaAccesibilidad())
                            && !r.getAmbiente().getAccesible();
                })
                .penalize(HardSoftScore.ONE_HARD, r -> 1)
                .asConstraint("Ambiente no accesible");
    }

    // …
    private Constraint maxReservasAsignadas(ConstraintFactory factory) {
        return factory.forEach(ReservaTentativa.class)
                .filter(r -> r.getAmbiente() != null && r.getBloqueInicio() != null)
                // recompensa proporcional a la prioridad:
                .reward(HardSoftScore.ONE_SOFT, ReservaTentativa::getPriority)
                .asConstraint("Reservas asignadas (ponderadas)");
    }

    static class OverlapHelper {

        /**
         * Devuelve true si r1 y r2 se pisan en el tiempo.
         */
        public static boolean isOverlapping(ReservaTentativa r1, ReservaTentativa r2) {
            int start1 = r1.getBloqueInicio().getIndice();
            int end1   = start1 + r1.getDuracionBloques();
            int start2 = r2.getBloqueInicio().getIndice();
            int end2   = start2 + r2.getDuracionBloques();
            return start1 < end2 && start2 < end1;
        }
    }

}



