package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name ="Docente")
public class Docente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private java.lang.Long id;
    private Long usuario;
    private String serviciosDisponibles;
    private java.lang.Long tarifa;
    private String historialDeUsuariosAtendidos;

    public Docente() {
    }

    public Docente(java.lang.Long id, Long usuario, String serviciosDisponibles, java.lang.Long tarifa, String historialDeUsuariosAtendidos) {
        this.id = id;
        this.usuario = usuario;
        this.serviciosDisponibles = serviciosDisponibles;
        this.tarifa = tarifa;
        this.historialDeUsuariosAtendidos = historialDeUsuariosAtendidos;
    }

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setIdUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public String getServiciosDisponibles() {
        return serviciosDisponibles;
    }

    public void setServiciosDisponibles(String serviciosDisponibles) {
        this.serviciosDisponibles = serviciosDisponibles;
    }

    public java.lang.Long getTarifa() {
        return tarifa;
    }

    public void setTarifa(java.lang.Long tarifa) {
        this.tarifa = tarifa;
    }

    public String getHistorialDeUsuariosAtendidos() {
        return historialDeUsuariosAtendidos;
    }

    public void setHistorialDeUsuariosAtendidos(String historialDeUsuariosAtendidos) {
        this.historialDeUsuariosAtendidos = historialDeUsuariosAtendidos;
    }
}
