package com.uam.springboot.manager.app.model.catalogos;

import java.time.DayOfWeek;

public enum DIASSEMANA {
    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;

    public static DIASSEMANA fromDayOfWeek(DayOfWeek dw) {
        return switch(dw) {
            case MONDAY    -> LUNES;
            case TUESDAY   -> MARTES;
            case WEDNESDAY -> MIERCOLES;
            case THURSDAY  -> JUEVES;
            case FRIDAY    -> VIERNES;
            case SATURDAY  -> SABADO;
            case SUNDAY    -> DOMINGO;
        };
    }
}

