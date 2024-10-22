package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="UsuarioFechaCurso")
public class UsuarioFechaCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Usuario usuario;
    private FechaCurso fechaCurso;
    private String estado;

    public UsuarioFechaCurso(){
    }

    public UsuarioFechaCurso(Long id, Usuario usuario, FechaCurso fechaCurso, String estado) {
        this.id = id;
        this.usuario = usuario;
        this.fechaCurso = fechaCurso;
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
