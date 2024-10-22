package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name ="Curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String titulo;
    private String descripcion;
    private Long precio;
    private Profesional profesional;
    private String estado;

    public Curso() {
    }
    public Curso(Long id, String titulo, String descripcion, Long precio, Profesional profesional, String estado){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.profesional = profesional;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public getPrecio(){
        return precio;
    }
    public void setPrecio(Long precio){
        this.precio = precio;
    }
    public getProfesional(){
        return profesional;
    }
    public void setProfesional(Profesional profesional){
        this.profesional = profesional;
    }
    public getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
}
