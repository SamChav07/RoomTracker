package com.uam.springboot.manager.app.services;

import com.uam.springboot.manager.app.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario usuario);
    void deleteById(Long id);
    Usuario findByUsuario(String usuario);
}
