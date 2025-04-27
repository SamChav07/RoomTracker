package com.uam.springboot.manager.app.repository.catalogos;

import com.uam.springboot.manager.app.model.catalogos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
