package com.uam.springboot.manager.app.dto.solver;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class PlanificacionResultadoDTO {
        private List<ReservaDTO> asignadas;
        private List<ReservaRechazadaDTO> rechazadas;

        public PlanificacionResultadoDTO() {}

        public PlanificacionResultadoDTO(List<ReservaDTO> asignadas, List<ReservaRechazadaDTO> rechazadas) {
            this.asignadas = asignadas;
            this.rechazadas = rechazadas;
        }
}

