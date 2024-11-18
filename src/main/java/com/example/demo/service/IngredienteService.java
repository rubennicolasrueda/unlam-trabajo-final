package com.example.demo.service;

import com.example.demo.model.Ingrediente;
import com.example.demo.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredienteService {

    @Autowired
    IngredienteRepository ingredienteRepository;

    public List<Ingrediente> obtenerIngredientes() {
        List<Ingrediente> ingredientes = new ArrayList<>();
        ingredienteRepository.findAll().forEach(ingredientes::add);
        return ingredientes;
    }

    public List<String> obtenerNombresIngredientes() {
        return ingredienteRepository.getNombreAll() ;
    }
}
