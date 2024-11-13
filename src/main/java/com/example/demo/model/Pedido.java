package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="Pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private java.lang.Long id;
    private Long usuario;
    private LocalDate fechaAlta;
    private LocalDate fechaActualizacion;
    private String estado;

    public Pedido(){
    }
    public Pedido(java.lang.Long id, Long usuario, LocalDate fechaAlta, LocalDate fechaActualizacion, String estado){
        this.id = id;
        this.usuario = usuario;
        this.fechaAlta = fechaAlta;
        this.fechaActualizacion = fechaActualizacion;
        this.estado = estado;
    }
    public java.lang.Long getId(){
        return id;
    }
    public void setId(java.lang.Long id){
        this.id = id;
    }
    public Long getUsuario(){
        return usuario;
    }
    public void setUsuario(Long usuario){
        this.usuario = usuario;
    }
    public LocalDate getFechaAlta(){
        return fechaAlta;
    }
    public void setFechaAlta(LocalDate fechaAlta){
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }
    public void setFechaActualizacion(LocalDate fechaActualizacion){
        this.fechaActualizacion = fechaActualizacion;
    }
    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
