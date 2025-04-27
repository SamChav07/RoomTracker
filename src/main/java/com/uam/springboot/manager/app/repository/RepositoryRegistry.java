package com.uam.springboot.manager.app.repository;

import com.uam.springboot.manager.app.model.catalogos.EquipoAmbiente;
import com.uam.springboot.manager.app.repository.catalogos.EquipoAmbienteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RepositoryRegistry {

    private final Map<Class<?>, JpaRepository<?, ?>> repositories = new HashMap<>();

    public RepositoryRegistry(
            EquipoAmbienteRepository equipoAmbienteRepository
            // Otros repositorios...
    ) {
        repositories.put(EquipoAmbiente.class, equipoAmbienteRepository);
        // Agrega otros repositorios aquí
    }

    public JpaRepository<?, ?> getRepository(Class<?> entityClass) {
        return repositories.get(entityClass);
    }
}
