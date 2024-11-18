package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="fecha_curso")
public class FechaCurso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_fecha_curso")
    private Long id;
    private LocalDateTime fecha;

    @ManyToOne()
    @JoinColumn(name= "id_curso")
    private Curso curso;

    public FechaCurso(){
    }
    public FechaCurso(Long id, LocalDateTime fecha, Curso curso){
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
    public LocalDateTime getFecha(){
        return fecha;
    }
    public void setFecha(LocalDateTime fecha){
        this.fecha = fecha;
    }
    public Curso getCurso(){
        return curso;
    }
    public void setCurso(Curso curso){
        this.curso = curso;
    }
}
