package com.example.demo.repository;


import com.example.demo.model.Receta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RecetaRepository extends CrudRepository<Receta, Long > {

    @Query(
            nativeQuery = true,
            value = "SELECT r.* FROM receta r inner join receta_ingrediente ri on ri.id_receta = r.id_receta inner join ingrediente i on ri.id_ingrediente = i.id_ingrediente where i.nombre in ? "
    )
    List<Receta> findByIngredientesIn(List<String> ingredientes);

    @Query(
            nativeQuery = true,
            value = "SELECT r.* FROM receta r inner join receta_categoria rc on rc.id_receta = r.id_receta inner join categoria c on rc.id_categoria = c.id_categoria where c.descripcion = ? "
    )
    List<Receta> findByCategoria(String categoria);

    Receta findByTitulo(String titulo);
}
