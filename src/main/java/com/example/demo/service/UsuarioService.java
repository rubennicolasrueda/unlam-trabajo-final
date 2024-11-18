package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario obtenerUsuario(long id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombreDeUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Map `Usuario` to `UserDetails`
        return User.builder()
                .username(usuario.getNombreDeUsuario())
                .password(passwordEncoder.encode(usuario.getContraseña()))
                .roles(usuario.getTipoDeUsuario())
                .build();
    }

    public Long obtenerUsuario() {
        UserDetails nombreUsuario = loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Usuario usuario = usuarioRepository.findByNombreDeUsuario(nombreUsuario.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + nombreUsuario));;
        return usuario.getId();
    }
}
