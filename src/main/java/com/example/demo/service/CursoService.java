package com.example.demo.service;

import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public void crearCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    public List<Curso> obtenerCursosDisponibles() {
        return (List<Curso>) cursoRepository.findAll();
    }

    public List<Curso> obtenerMisCursos(Long usuarioId) {
        return cursoRepository.obtenerCursosPorUsuarioId(usuarioId);
    }
}
