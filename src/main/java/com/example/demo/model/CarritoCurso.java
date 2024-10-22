package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name ="CarritoCurso")
public class CarritoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private CarritoDeCompra carritoDeCompra;
    private Curso curso;

    public CarritoCurso(){
    }
    public CarritoCurso(Long id, CarritoDeCompra carritoDeCompra, Curso curso){
        this.id = id;
        this.carritoDeCompra = carritoDeCompra;
        this.curso = curso;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public CarritoDeCompra getCarritoDeCompra(){
        return carritoDeCompra;
    }
    public void setCarritoDeCompra(CarritoDeCompra CarritoDeCompra){
        this.carritoDeCompra = carritoDeCompra;
    }
    public Curso getCurso(){
        return curso;
    }
    public void setCurso(Curso curso){
        this.curso = curso;
    }

}
