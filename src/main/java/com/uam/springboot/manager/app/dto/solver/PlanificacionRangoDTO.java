package com.uam.springboot.manager.app.dto.solver;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlanificacionRangoDTO {
    private List<PlanificacionDiaDTO> dias;
}
