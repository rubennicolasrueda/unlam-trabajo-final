package com.example.demo.repository;

import com.example.demo.model.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaRepository extends CrudRepository<Categoria, Long > {

    @Query(
            nativeQuery = true,
            value = "SELECT c.descripcion FROM categoria c"
    )
    List<String> getDescripcionAll();

}
