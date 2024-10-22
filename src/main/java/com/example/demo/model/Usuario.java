package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombreCompleto;
    private String email;
    private String contraseña;
    private String tipoDeUsuario;
    private Categoria id;
    private String nombreDeUsuario;
    private LocalDate fechaAlta;
    private LocalDate fechaBaja;

    public Usuario() {
    }

    public Usuario(Long id, String nombreCompleto, String email, String contraseña, String tipoDeUsuario, Categoria id1, String nombreDeUsuario, LocalDate fechaAlta, LocalDate fechaBaja) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.contraseña = contraseña;
        this.tipoDeUsuario = tipoDeUsuario;
        this.id = id1;
        this.nombreDeUsuario = nombreDeUsuario;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Categoria id) {
        this.id = id;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }
}
