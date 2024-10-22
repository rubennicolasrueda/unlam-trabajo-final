package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "RecetaCategoria")
public class RecetaCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private Categoria categoria;
    private Receta receta;

    public RecetaCategoria() {
    }

    public RecetaCategoria(Long id, Categoria categoria, Receta receta) {
        this.id = id;
        this.categoria = categoria;
        this.receta = receta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }
}
