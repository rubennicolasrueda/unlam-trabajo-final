package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignUpController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/sign-up")
    public String signUp() {
        return "perfil-usuario/alta-usuario";
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Void> altaUsuario(@ModelAttribute("usuario")Usuario usuario) {
        try {
            usuarioService.altaUsuario(usuario);
            return ResponseEntity.ok().build(); // 200 OK for success
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 for error
        }
    }
    @GetMapping("/usuario")
    public String usuario() {return "perfil-usuario/alta-usuario";}

}
