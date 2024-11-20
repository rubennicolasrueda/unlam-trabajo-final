package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "pedido_ingrediente")
public class PedidoIngrediente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pedido_ingrediente")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_ingrediente")
    private Ingrediente ingrediente;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
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
