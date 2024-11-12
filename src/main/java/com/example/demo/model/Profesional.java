package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name ="Profesional")
public class Profesional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private java.lang.Long id;
    private String especialidad;
    private String serviciosDisponibles;
    private java.lang.Long tarifa;
    private String historialDeUsuariosAtendidos;
    private String planesDieteticosAsignados;
    private Long usuario;

    public Profesional() {
    }

    public Profesional(java.lang.Long id, String especialidad, String serviciosDisponibles, java.lang.Long tarifa, String historialDeUsuariosAtendidos, String planesDieteticosAsignados, Long usuario) {
        this.id = id;
        this.especialidad = especialidad;
        this.serviciosDisponibles = serviciosDisponibles;
        this.tarifa = tarifa;
        this.historialDeUsuariosAtendidos = historialDeUsuariosAtendidos;
        this.planesDieteticosAsignados = planesDieteticosAsignados;
        this.usuario = usuario;
    }

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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

    public String getPlanesDieteticosAsignados() {
        return planesDieteticosAsignados;
    }

    public void setPlanesDieteticosAsignados(String planesDieteticosAsignados) {
        this.planesDieteticosAsignados = planesDieteticosAsignados;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }
}
