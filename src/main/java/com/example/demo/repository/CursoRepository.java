package com.example.demo.repository;

import com.example.demo.model.Curso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CursoRepository extends CrudRepository<Curso, Long > {

    @Query(
            nativeQuery = true,
            value = "SELECT c.* FROM usuario_fecha_curso ufc inner join fecha_curso fc on ufc.id_fecha_curso = fc.id_fecha_curso inner join curso c on fc.id_curso = c.id_curso where ufc.id_usuario = ?"
    )
    List<Curso> obtenerCursosPorUsuarioId(Long usuarioId);
}
