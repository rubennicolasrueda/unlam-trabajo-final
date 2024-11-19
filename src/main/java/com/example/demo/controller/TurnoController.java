package com.example.demo.controller;

import com.example.demo.model.ConsultaProfesional;
import com.example.demo.service.TurnoService;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;


@Controller
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TurnoService turnoService;

    @GetMapping("/turno")
    public String curso(Model model) {
        model.addAttribute("turnos", turnoService.obtenerTurnosDisponibles());
        Long usuarioId = usuarioService.obtenerUsuario();
        model.addAttribute("misTurnos", turnoService.obtenerMisTurnos(usuarioId));
        return "perfil-nutricionista/turnos";
    }

    @GetMapping("/videollamada")
    public String videollamada() {
        return "perfil-nutricionista/videollamada";
    }

}
