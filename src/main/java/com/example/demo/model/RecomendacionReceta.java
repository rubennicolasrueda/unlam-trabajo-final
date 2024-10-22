package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "RecomendacionReceta")
public class RecomendacionReceta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private Usuario usuario;
    private Receta receta;
    private LocalDate fechaAlta;
    private LocalDate fechaActualizacion;

    public RecomendacionReceta() {
    }

    public RecomendacionReceta(Long id, Usuario usuario, Receta receta, LocalDate fechaAlta, LocalDate fechaActualizacion) {
        this.id = id;
        this.usuario = usuario;
        this.receta = receta;
        this.fechaAlta = fechaAlta;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
