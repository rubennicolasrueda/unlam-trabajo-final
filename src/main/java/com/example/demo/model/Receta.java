package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Receta")
public class Receta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_receta")
    private Long id;
    private String titulo;
    private String descripcion;
    @Column(name = "valor_nutricional")
    private String valorNutricional;
    private String imagen;
    @Column(name = "tipo_de_receta")
    private String tipoDeReceta;
    @Column(name = "usuario_que_la_creo")
    private String usuarioQueLaCreo;

    public Receta() {
    }

    public Receta(Long id, String titulo, String descripcion, String valorNutricional, String imagen, String tipoDeReceta, String usuarioQueLaCreo) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.valorNutricional = valorNutricional;
        this.imagen = imagen;
        this.tipoDeReceta = tipoDeReceta;
        this.usuarioQueLaCreo = usuarioQueLaCreo;

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

    public String getValorNutricional() {
        return valorNutricional;
    }

    public void setValorNutricional(String valorNutricional) {
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
        return usuarioQueLaCreo;
    }

    public void setUsuarioQueLaCreo(String usuarioQueLaCreo) {
        usuarioQueLaCreo = usuarioQueLaCreo;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", valorNutricional=" + valorNutricional +
                ", imagen='" + imagen + '\'' +
                ", tipoDeReceta='" + tipoDeReceta + '\'' +
                ", UsuarioQueLaCreo='" + usuarioQueLaCreo + '\'' +
                '}';
    }

}
