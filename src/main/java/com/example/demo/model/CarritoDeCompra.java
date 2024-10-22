package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "CarritoDeCompra")
public class CarritoDeCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Usuario usuario;
    private Pago pago;
    private LocalDate fechaAlta;
    private LocalDate fechaActualizacion;
    private String estado;

    public CarritoDeCompra(){
    }
    public CarritoDeCompra(Long id, Usuario usuario, Pago pago, LocalDate fechaAlta, LocalDate fechaActualizacion, String estado){
        this.id = id;
        this.usuario = usuario;
        this.pago = pago;
        this.fechaAlta = fechaAlta;
        this.fechaActualizacion = fechaActualizacion;
        this.estado = estado;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public Pago getPago(){
        return pago;
    }
    public void setPago(Pago pago){
        this.pago = pago;
    }
    public LocalDate getFechaAlta(){
        return fechaAlta;
    }
    public void setFechaAlta(LocalDate fechaAlta){
        this.fechaAlta = fechaAlta;
    }
    public LocalDate getFechaActualizacion(){
        return fechaActualizacion;
    }
    public void setFechaActualizacion(LocalDate fechaActualizacion){
        this.fechaActualizacion = fechaActualizacion;
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
}
