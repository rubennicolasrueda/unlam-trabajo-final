package com.example.demo.repository;

import com.example.demo.model.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT p.* FROM pedido p WHERE p.id_usuario = ?"
    )
    List<Pedido> obtenerMisPedidos(Long usuarioId);
}
