package com.example.demo.repository;

import com.example.demo.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Optional<Usuario> findByNombreDeUsuario(String nombreDeUsuario);

}
