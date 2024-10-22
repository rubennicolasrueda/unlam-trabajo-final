package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "RecetaIngrediente")
public class RecetaIngrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Ingrediente ingrediente;
    private Receta receta;

    public RecetaIngrediente() {
    }

    public RecetaIngrediente(Long id, Ingrediente ingrediente, Receta receta) {
        this.id = id;
        this.ingrediente = ingrediente;
        this.receta = receta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }
}
