package com.example.demo.controller;

import com.example.demo.model.Curso;
import com.example.demo.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/alta-curso")
    public String altaCurso() {
        return "perfil-curso/alta-curso";
    }


    @PostMapping("/alta-curso")
    public ResponseEntity<Void> crearCurso(@ModelAttribute("curso") Curso curso) {
        try{
            curso.setEstado("ACTIVO");
            curso.setProfesional(1L);
            cursoService.crearCurso(curso);
            return ResponseEntity.ok().build(); // 200 OK for success
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 for error
        }
    }

    @GetMapping("/curso")
    public String curso() {
        return "perfil-curso/cursos";
    }
}
