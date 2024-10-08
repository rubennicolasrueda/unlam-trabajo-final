package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecetaController {

    @GetMapping("/arma-receta")
    public String armaReceta() {
        return "perfil-usuario/arma-recetas";
    }

}
