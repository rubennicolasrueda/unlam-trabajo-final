package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/turnos")
public class TurnoController {

    @GetMapping("/turno")
    public String curso() {
        return "perfil-nutricionista/turnos";
    }

}
