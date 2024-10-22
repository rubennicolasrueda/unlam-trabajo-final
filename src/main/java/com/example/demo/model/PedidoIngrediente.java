package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PedidoIngrediente")
public class PedidoIngrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private Ingrediente ingrediente;
    private Pedido pedido;

    public PedidoIngrediente(){
    }

    public PedidoIngrediente(Long id, Ingrediente ingrediente, Pedido pedido) {
        this.id = id;
        this.ingrediente = ingrediente;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
