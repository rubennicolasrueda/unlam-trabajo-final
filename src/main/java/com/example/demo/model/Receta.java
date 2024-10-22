package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Receta")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String titulo;
    private String descripcion;
    private Long valorNutricional;
    private String imagen;
    private String tipoDeReceta;
    private String UsuarioQueLaCreo;

    public Receta() {
    }

    public Receta(Long id, String titulo, String descripcion, Long valorNutricional, String imagen, String tipoDeReceta, String usuarioQueLaCreo) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.valorNutricional = valorNutricional;
        this.imagen = imagen;
        this.tipoDeReceta = tipoDeReceta;
        UsuarioQueLaCreo = usuarioQueLaCreo;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getValorNutricional() {
        return valorNutricional;
    }

    public void setValorNutricional(Long valorNutricional) {
        this.valorNutricional = valorNutricional;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTipoDeReceta() {
        return tipoDeReceta;
    }

    public void setTipoDeReceta(String tipoDeReceta) {
        this.tipoDeReceta = tipoDeReceta;
    }

    public String getUsuarioQueLaCreo() {
        return UsuarioQueLaCreo;
    }

    public void setUsuarioQueLaCreo(String usuarioQueLaCreo) {
        UsuarioQueLaCreo = usuarioQueLaCreo;
    }
}
