package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "carrito_de_compras")
public class CarritoDeCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_carrito")
    private Long id;
    @Column(name="id_usuario")
    private Long usuario;
    @Column(name="id_pago")
    private Long pago;
    private LocalDate fechaAlta;
    private LocalDate fechaActualizacion;
    private String estado;

    public CarritoDeCompra(){
    }
    public CarritoDeCompra(Long id, Long usuario, Long pago, LocalDate fechaAlta, LocalDate fechaActualizacion, String estado){
        this.id = id;
        this.usuario = usuario;
        this.pago = pago;
        this.fechaAlta = fechaAlta;
        this.fechaActualizacion = fechaActualizacion;
        this.estado = estado;
    }
    public java.lang.Long getId(){
        return id;
    }
    public void setId(java.lang.Long id){
        this.id = id;
    }
    public Long getUsuario(){
        return usuario;
    }
    public void setUsuario(Long usuario){
        this.usuario = usuario;
    }
    public Long getPago(){
        return pago;
    }
    public void setPago(Long pago){
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
