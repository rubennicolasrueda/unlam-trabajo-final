package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "consulta_profesional")
public class ConsultaProfesional implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private java.lang.Long id;
    private Long usuario;
    private Profesional profesional;
    private LocalDateTime fechaHora;
    private String planNutricional;
    private java.lang.Long tarifa;
    private String estado;

    public ConsultaProfesional() {
    }

    public ConsultaProfesional(java.lang.Long id, Long usuario, Profesional profesional, LocalDateTime fechaHora, String planNutricional, java.lang.Long tarifa, String estado) {
        this.id = id;
        this.usuario = usuario;
        this.profesional = profesional;
        this.fechaHora = fechaHora;
        this.planNutricional = planNutricional;
        this.tarifa = tarifa;
        this.estado = estado;
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

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getPlanNutricional() {
        return planNutricional;
    }

    public void setPlanNutricional(String planNutricional) {
        this.planNutricional = planNutricional;
    }

    public java.lang.Long getTarifa() {
        return tarifa;
    }

    public void setTarifa(java.lang.Long tarifa) {
        this.tarifa = tarifa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
