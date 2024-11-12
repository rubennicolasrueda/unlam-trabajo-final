package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Ingrediente")
public class Ingrediente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ingrediente")
    private Long ingrediente;
    private String nombre;
    private String categoria;
    @Column(name = "valor_nutricional")
    private Long valorNutricional;

    public Ingrediente(){
    }

    public Ingrediente(Long ingrediente, String nombre, String categoria, Long valorNutricional) {
        this.ingrediente = ingrediente;
        this.nombre = nombre;
        this.categoria = categoria;
        this.valorNutricional = valorNutricional;
    }

    public Long getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Long ingrediente) {
        this.ingrediente = ingrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getValorNutricional() {
        return valorNutricional;
    }

    public void setValorNutricional(Long valorNutricional) {
        this.valorNutricional = valorNutricional;
    }
}
