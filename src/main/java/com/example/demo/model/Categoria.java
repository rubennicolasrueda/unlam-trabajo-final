package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long categoria;
    private String descripcion;

    public Categoria() {
    }

    public Categoria(Long categoria, String descripcion) {
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
