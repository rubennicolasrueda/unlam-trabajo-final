package com.example.demo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name ="Profesional")
public class Profesional {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String especialidad;
    private String serviciosDisponibles;
    private Long tarifa;
    private String historialDeUsuariosAtendidos;
    private String planesDieteticosAsignados;
    private Usuario usuario;

    public Profesional() {
    }

    public Profesional(Long id, String especialidad, String serviciosDisponibles, Long tarifa, String historialDeUsuariosAtendidos, String planesDieteticosAsignados, Usuario usuario) {
        this.id = id;
        this.especialidad = especialidad;
        this.serviciosDisponibles = serviciosDisponibles;
        this.tarifa = tarifa;
        this.historialDeUsuariosAtendidos = historialDeUsuariosAtendidos;
        this.planesDieteticosAsignados = planesDieteticosAsignados;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getTarifa() {
        return tarifa;
    }

    public void setTarifa(Long tarifa) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
