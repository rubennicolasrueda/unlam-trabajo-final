package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "recomendaciones_receta")
public class RecomendacionReceta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name ="id_usuario")
    private Long usuario;
    @Column(name ="id_receta")
    private Long receta;

    private LocalDate fechaAlta;
    private LocalDate fechaActualizacion;

    public RecomendacionReceta() {
    }

    public RecomendacionReceta(Long usuario, Long receta, LocalDate fechaAlta, LocalDate fechaActualizacion) {
        this.usuario = usuario;
        this.receta = receta;
        this.fechaAlta = fechaAlta;
        this.fechaActualizacion = fechaActualizacion;
    }

    public java.lang.Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Long getReceta() {
        return receta;
    }

    public void setReceta(Long receta) {
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
