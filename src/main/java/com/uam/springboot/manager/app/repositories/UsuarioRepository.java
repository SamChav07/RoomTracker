package com.uam.springboot.manager.app.repositories;

import com.uam.springboot.manager.app.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Usuario findByUsuario(String usuario);
}
