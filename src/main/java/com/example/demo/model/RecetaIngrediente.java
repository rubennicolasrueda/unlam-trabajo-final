package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "receta_ingrediente")
public class RecetaIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_receta_ingrediente")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_ingrediente")
    private Ingrediente ingrediente;

    @ManyToOne()
    @JoinColumn(name = "id_receta")
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
