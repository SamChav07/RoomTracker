package com.uam.springboot.manager.app.repository.catalogos;


import com.uam.springboot.manager.app.model.catalogos.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
}
