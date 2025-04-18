package com.uam.springboot.manager.app.entities;

public enum HORARIO {

    PERIODO_1("7:00 AM", "7:50 AM"),
    PERIODO_2("8:00 AM", "8:50 AM"),
    PERIODO_3("9:00 AM", "9:50 AM"),
    PERIODO_4("10:00 AM", "10:50 AM"),
    PERIODO_5("11:00 AM", "11:50 AM"),
    PERIODO_6("12:00 PM", "12:50 PM"),
    PERIODO_7("1:00 PM", "1:50 PM"),
    PERIODO_8("2:00 PM", "2:50 PM"),
    PERIODO_9("3:00 PM", "3:50 PM"),
    PERIODO_10("4:00 PM", "4:50 PM"),
    PERIODO_11("5:00 PM", "5:50 PM"),
    PERIODO_12("5:50 PM", "6:40 PM"),
    PERIODO_13("6:45 PM", "7:35 PM"),
    PERIODO_14("7:40 PM", "8:30 PM"),
    PERIODO_15("8:30 PM", "9:20 PM");

    private final String inicio;
    private final String fin;

    HORARIO(String inicio, String fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getInicio() {
        return inicio;
    }

    public String getFin() {
        return fin;
    }

    @Override
    public String toString() {
        return this.name() + " (" + inicio + " - " + fin + ")";
    }
}

