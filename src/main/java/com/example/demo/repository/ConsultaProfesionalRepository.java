package com.example.demo.repository;

import com.example.demo.model.ConsultaProfesional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConsultaProfesionalRepository extends CrudRepository<ConsultaProfesional,Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT cp.* FROM consulta_profesional cp WHERE cp.id_usuario = ?"
    )
    List<ConsultaProfesional> obtenerConsultaProfesionalPorUsuarioId(Long usuarioId);
}
