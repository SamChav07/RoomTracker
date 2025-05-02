package com.uam.springboot.manager.app.model.solver;

import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.config.constructionheuristic.ConstructionHeuristicPhaseConfig;
import org.optaplanner.core.config.localsearch.LocalSearchPhaseConfig;
import org.optaplanner.core.config.score.director.ScoreDirectorFactoryConfig;
import org.optaplanner.core.config.solver.SolverConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.optaplanner.core.config.constructionheuristic.ConstructionHeuristicType;
import org.optaplanner.core.config.localsearch.LocalSearchType;
import org.optaplanner.core.config.solver.termination.TerminationConfig;


@Configuration
public class OptaPlannerJavaConfig {

    @Bean
    public SolverFactory<PlanificacionDiariaSolver> solverFactory() {
        SolverConfig config = new SolverConfig();
        // 1️⃣ Solución y entidades
        config.setSolutionClass(PlanificacionDiariaSolver.class);
        config.setEntityClassList(List.of(ReservaTentativa.class));
        // 2️⃣ ConstraintProvider
        ScoreDirectorFactoryConfig sd = new ScoreDirectorFactoryConfig();
        sd.setConstraintProviderClass(PlanificacionConstraintProvider.class);
        config.setScoreDirectorFactoryConfig(sd);
        // 3️⃣ Terminación (20s)
        config.setTerminationConfig(new TerminationConfig()
                .withSecondsSpentLimit(20L));
        // 4️⃣ Fases: construcción + búsqueda local
        config.setPhaseConfigList(List.of(
                new ConstructionHeuristicPhaseConfig()
                        .withConstructionHeuristicType(ConstructionHeuristicType.FIRST_FIT),
                new LocalSearchPhaseConfig()
                        .withLocalSearchType(LocalSearchType.TABU_SEARCH)
        ));
        return SolverFactory.create(config);
    }

    @Bean
    public SolverManager<PlanificacionDiariaSolver, Long> solverManager(
            SolverFactory<PlanificacionDiariaSolver> solverFactory) {
        return SolverManager.create(solverFactory);
    }
}

