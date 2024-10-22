package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ConsultaProfesional")
public class ConsultaProfesional {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private Usuario usuario;
    private Profesional profesional;
    private LocalDateTime fechaHora;
    private String planNutricional;
    private Long tarifa;
    private String estado;

    public ConsultaProfesional() {
    }

    public ConsultaProfesional(Long id, Usuario usuario, Profesional profesional, LocalDateTime fechaHora, String planNutricional, Long tarifa, String estado) {
        this.id = id;
        this.usuario = usuario;
        this.profesional = profesional;
        this.fechaHora = fechaHora;
        this.planNutricional = planNutricional;
        this.tarifa = tarifa;
        this.estado = estado;
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

    public Long getTarifa() {
        return tarifa;
    }

    public void setTarifa(Long tarifa) {
        this.tarifa = tarifa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
