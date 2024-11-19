package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_usuario")
    private Long id;

    @Column(name="nombre_completo")
    private String nombreCompleto;

    private String email;

    private String contraseña;

    @Column(name="tipo_de_usuario")
    private String tipoDeUsuario;

    @Column(name="id_categoria")
    private Long idCategoria;

    @Column(name="nombre_de_usuario")
    private String nombreDeUsuario;

    @Column(name="fecha_alta")
    private LocalDate fechaAlta;

    @Column(name="fecha_baja")
    private LocalDate fechaBaja;

    @OneToOne(mappedBy = "usuario")
    private Profesional profesional;

    public Usuario() {
    }

    public Usuario(Long id, String nombreCompleto, String email, String contraseña, String tipoDeUsuario, Long idCategoria, String nombreDeUsuario, LocalDate fechaAlta, LocalDate fechaBaja) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.contraseña = contraseña;
        this.tipoDeUsuario = tipoDeUsuario;
        this.idCategoria = idCategoria;
        this.nombreDeUsuario = nombreDeUsuario;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setIdCategoria(Long id) {
        this.idCategoria = idCategoria;
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
