package com.example.demo.controller;

import com.example.demo.model.Curso;
import com.example.demo.service.CursoService;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private UsuarioService usuarioService;

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
    public String curso(Model model) {

        List<Curso> cursos = cursoService.obtenerCursosDisponibles();
        model.addAttribute("cursos", cursos );

        return "perfil-curso/cursos";
    }

    @GetMapping("/mis-cursos")
    public String misCursos(Model model) {
        Long usuarioId = usuarioService.obtenerUsuario();
        List<Curso> misCursos = cursoService.obtenerMisCursos(usuarioId);
        model.addAttribute("misCursos", misCursos );
        return "perfil-curso/mis-cursos";
    }

    @GetMapping("/streaming")
    public String streaming() {
        return "perfil-curso/streaming";
    }

}
