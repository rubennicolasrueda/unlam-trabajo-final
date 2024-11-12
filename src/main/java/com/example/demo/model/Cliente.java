package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private java.lang.Long id;
    private Long usuario;

    public Cliente() {
    }

    public Cliente(java.lang.Long id, Long usuario) {
        this.id = id;
        this.usuario = usuario;
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
}
