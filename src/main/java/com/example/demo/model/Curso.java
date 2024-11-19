package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name ="curso")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_curso")
    private Long id;
    private String titulo;
    private String descripcion;
    private BigDecimal precio;
    @Column(name="id_profesional")
    private Long profesional;
    private String estado;

    @OneToMany(mappedBy = "curso")
    private Set<FechaCurso> fechaCursos;

    public Curso() {
    }
    public Curso(Long id, String titulo, String descripcion, BigDecimal precio, Long profesional, String estado){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.profesional = profesional;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public BigDecimal getPrecio(){
        return precio;
    }
    public void setPrecio(BigDecimal precio){
        this.precio = precio;
    }
    public Long getProfesional(){
        return profesional;
    }
    public void setProfesional(Long profesional){
        this.profesional = profesional;
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }

    public Set<String> getFecha() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");

        return fechaCursos.stream()
                .map(fechaCurso -> fechaCurso.getFecha().format(formatter))
                .collect(Collectors.toSet());
    }

}
