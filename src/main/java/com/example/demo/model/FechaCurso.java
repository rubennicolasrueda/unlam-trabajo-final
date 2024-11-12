package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="fecha_curso")
public class FechaCurso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate fecha;
    private Curso curso;

    public FechaCurso(){
    }
    public FechaCurso(Long id, LocalDate fecha, Curso curso){
        this.id = id;
        this.fecha = fecha;
        this.curso = curso;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDate getFecha(){
        return fecha;
    }
    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }
    public Curso getCurso(){
        return curso;
    }
    public void setCurso(Curso curso){
        this.curso = curso;
    }
}
