package com.example.demo.service;

import com.example.demo.model.ConsultaProfesional;
import com.example.demo.repository.ConsultaProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    @Autowired
    ConsultaProfesionalRepository consultaProfesionalRepository;

    public List<ConsultaProfesional> obtenerMisTurnos(Long usuarioId) {
        return consultaProfesionalRepository.obtenerConsultaProfesionalPorUsuarioId(usuarioId);
    }

    public List<ConsultaProfesional> obtenerTurnosDisponibles() {
        return (List<ConsultaProfesional>) consultaProfesionalRepository.findAll();
    }
}
