package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name ="Docente")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private Usuario usuario;
    private String serviciosDisponibles;
    private Long tarifa;
    private String historialDeUsuariosAtendidos;

    public Docente() {
    }

    public Docente(Long id, Usuario usuario, String serviciosDisponibles, Long tarifa, String historialDeUsuariosAtendidos) {
        this.id = id;
        this.usuario = usuario;
        this.serviciosDisponibles = serviciosDisponibles;
        this.tarifa = tarifa;
        this.historialDeUsuariosAtendidos = historialDeUsuariosAtendidos;
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

    public void setIdUsuario(Usuario usuario) {
        this.usuario = usuario;
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
}
