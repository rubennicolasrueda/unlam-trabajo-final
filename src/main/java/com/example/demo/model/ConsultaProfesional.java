package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "consulta_profesional")
public class ConsultaProfesional implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_consulta")
    private Long id;

    @Column(name = "id_usuario")
    private Long usuario;

    @ManyToOne
    @JoinColumn(name = "id_profesional")
    private Profesional profesional;

    @Column(name = "fecha_y_hora")
    private LocalDateTime fechaHora;
    @Column(name = "plan_nutricional")
    private String planNutricional;
    private BigDecimal tarifa;
    private String estado;

    public ConsultaProfesional() {
    }

    public ConsultaProfesional(Long id, Long usuario, Profesional profesional, LocalDateTime fechaHora, String planNutricional, BigDecimal tarifa, String estado) {
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

    public String getFechaHora() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
        return fechaHora.format(formatter);
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

    public BigDecimal getTarifa() {
        return tarifa;
    }

    public void setTarifa(BigDecimal tarifa) {
        this.tarifa = tarifa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreCompletoProfesional(){
        return profesional.getUsuario().getNombreCompleto();
    }

    public String getEspecialidad(){
        return profesional.getEspecialidad();
    }
}
