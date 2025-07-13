package com.uam.springboot.manager.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping({"/crear/{entidad}", "/listar/{entidad}", "/all/{entidad}"})
public class ViewRouter {
    @GetMapping
    public String route(@PathVariable String entidad, Model model) {
        // Inyecta “AmbienteDto”, “ProfesorDto”, etc. según convención
        model.addAttribute("dtoName", entidad + "RequestDTO");
        model.addAttribute("pageAction",
                // “crear”, “listar” o “all”
                ServletUriComponentsBuilder.fromCurrentRequest().build().getPath().split("/")[1]
        );
        // Devuelve siempre la misma plantilla genérica:
        return "entity-crud";
    }
}
