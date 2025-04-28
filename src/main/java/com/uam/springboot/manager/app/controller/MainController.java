package com.uam.springboot.manager.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/gpt")
    public String showTPage(Model model) {
        return "gpt";
    }

    @GetMapping("/inicio")
    public String showInicioPage(Model model) {
        return "inicio";
    }

    @GetMapping("/crear/pAcademico")
    public String showPeriodoC_AcademicoPage(Model model) { // C R E A R - Periodo
        return "P_Academicos/crear_periodoAcademico";
    }
    @GetMapping("/listar/pAcademico")
    public String showPeriodoL_AcademicoPage(Model model) { // L I S T A R
        return "P_Academicos/listar_periodoAcademico";
    }

    @GetMapping("/crear/carrera")
    public String showC_CarreraPage(Model model) { // C R E A R - Carrera
        return "Carreras/crear_carrera";
    }

    @GetMapping("/listar/carrera")
    public String showL_CarreraPage(Model model) { // L I S T A R
        return "Carreras/listar_carrera";
    }

    @GetMapping("/crear/profesor")
    public String showC_ProfesorPage(Model model) { // C R E A R - Profesor
        return "Profesores/crear_profesor";
    }

    @GetMapping("/listar/profesor")
    public String showL_ProfesorPage(Model model) { // L I S T A R
        return "Profesores/listar_profesor";
    }

    @GetMapping("/crear/asignatura")
    public String showC_AsignaturaPage(Model model) { // C R E A R - Asignatura
        return "Asignaturas/crear_asignatura";
    }

    @GetMapping("/listar/asignatura")
    public String showL_AsignaturaPage(Model model) { // L I S T A R
        return "Asignaturas/listar_asignatura";
    }

    @GetMapping("/crear/coordinador")
    public String showC_CoordinadorPage(Model model) { // C R E A R - Coordinador
        return "Coordinador/crear_coordinador";
    }

    @GetMapping("/listar/coordinador")
    public String showL_CoordinadorPage(Model model) { // L I S T A R
        return "Coordinador/listar_coordinador";
    }

    @GetMapping("/crear/usuario")
    public String showC_UserPage(Model model) { // C R E A R - Usuario
        return "Usuario/crear_user";
    }

    @GetMapping("/listar/usuario")
    public String showL_UserPage(Model model) { // L I S T A R
        return "Usuario/listar_user";
    }

    @GetMapping("/all/roles")
    public String showC_RolPage(Model model) { // C R E A R - Rol
        return "Rol/crear_rol";
    }

    @GetMapping("/crear/ambiente")
    public String showC_AmbientePage(Model model) { // C R E A R - Ambiente
        return "Ambientes/crear_ambiente";
    }

    @GetMapping("/listar/ambiente")
    public String showL_AmbientePage(Model model) { // L I S T A R
        return "Ambientes/listar_ambiente";
    }

    @GetMapping("/crear/eAmbiente")
    public String showC_EquipoAmbientePage(Model model) { // C R E A R - Equipo Ambiente
        return "E_Ambientes/crear_equipoAmbiente";
    }

    @GetMapping("/listar/eAmbiente")
    public String showL_EquipoAmbientePage(Model model) { // L I S T A R
        return "E_Ambientes/listar_equipoAmbiente";
    }

    @GetMapping("/crear/bHorario")
    public String showC_BloqueHorarioPage(Model model) { // C R E A R - Bloques Horarios
        return "B_Horario/crear_bloqueHorario";
    }

    @GetMapping("/listar/bHorario")
    public String showL_BloqueHorarioPage(Model model) { // L I S T A R
        return "B_Horario/listar_bloqueHorario";
    }
}