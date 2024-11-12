package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="usuario_fecha_curso")
public class UsuarioFechaCurso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private java.lang.Long id;
    private Long usuario;
    private FechaCurso fechaCurso;
    private String estado;

    public UsuarioFechaCurso(){
    }

    public UsuarioFechaCurso(Long id, Long usuario, FechaCurso fechaCurso, String estado) {
        this.id = id;
        this.usuario = usuario;
        this.fechaCurso = fechaCurso;
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

    public FechaCurso getFechaCurso() {
        return fechaCurso;
    }

    public void setFechaCurso(FechaCurso fechaCurso) {
        this.fechaCurso = fechaCurso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
