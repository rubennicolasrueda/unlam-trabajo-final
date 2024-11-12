package com.example.demo.repository;

import com.example.demo.model.Ingrediente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long > {

    @Query(
            nativeQuery = true,
            value = "SELECT i.nombre FROM ingrediente i"
    )
    List<String> getNombreAll();

}
