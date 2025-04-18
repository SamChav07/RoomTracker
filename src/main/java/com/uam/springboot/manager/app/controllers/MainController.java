package com.uam.springboot.manager.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // Ruta para la vista de inicio
    @GetMapping("/inicio")
    public String showHomePage(Model model) {
        return "inicio";
    }

    // Ruta para la vista de ambiente
    @GetMapping("/ambiente")
    public String showAmbientePage(Model model) {
        return "ambiente"; // Retorna la vista base
    }

    // Ruta para la vista de asignación
    @GetMapping("/asignacion")
    public String showAsignacionPage(Model model) {
        return "asignacion"; // Retorna la vista base
    }

    // Ruta para la vista de carrera
    @GetMapping("/carrera")
    public String showCarreraPage(Model model) {
        return "carrera"; // Retorna la vista base
    }

    // Ruta para la vista de clase
    @GetMapping("/clase")
    public String showClasePage(Model model) {
        return "clase"; // Retorna la vista base
    }

    // Ruta para la vista de coordinador
    @GetMapping("/coordinador")
    public String showCoordinadorPage(Model model) {
        return "coordinador"; // Retorna la vista base
    }

    // Ruta para la vista de evento
    @GetMapping("/evento")
    public String showEventoPage(Model model) {
        return "evento"; // Retorna la vista base
    }

    // Ruta para la vista de facultad
    @GetMapping("/facultad")
    public String showFacultadPage(Model model) {
        return "facultad"; // Retorna la vista base
    }

    // Ruta para la vista de logística
    @GetMapping("/logistica")
    public String showLogisticaPage(Model model) {
        return "logistica"; // Retorna la vista base
    }

    // Ruta para la vista de profesor
    @GetMapping("/profesor")
    public String showProfesorPage(Model model) {
        return "profesor"; // Retorna la vista base
    }

    // Ruta para la vista de proyección
    @GetMapping("/proyeccion")
    public String showProyeccionPage(Model model) {
        return "proyeccion"; // Retorna la vista base
    }

    // Ruta para la vista de solicitud
    @GetMapping("/solicitud")
    public String showSolicitudPage(Model model) {
        return "solicitud"; // Retorna la vista base
    }
}