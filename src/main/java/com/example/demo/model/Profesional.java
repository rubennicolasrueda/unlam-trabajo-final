package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name ="profesional")
public class Profesional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_profesional")
    private Long id;
    private String especialidad;

    @Column(name = "servicios_disponibles")
    private String serviciosDisponibles;
    private BigDecimal tarifa;

    @Column(name = "historial_de_usuarios")
    private String historialDeUsuariosAtendidos;

    @Column(name = "planes_dieteticos_asignados")
    private String planesDieteticosAsignados;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "profesional")
    private Set<ConsultaProfesional> consultaProfesional;

    public Profesional() {
    }

    public Profesional(Long id, String especialidad, String serviciosDisponibles, BigDecimal tarifa, String historialDeUsuariosAtendidos, String planesDieteticosAsignados, Usuario usuario) {
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

    public BigDecimal getTarifa() {
        return tarifa;
    }

    public void setTarifa(BigDecimal tarifa) {
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
