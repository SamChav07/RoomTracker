package com.uam.springboot.manager.app.service.impl;

import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.Identifiable;
import com.uam.springboot.manager.app.service.interfaces.ICrudService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

    public class CrudServiceImpl<E extends Identifiable, RQ, RS, ID> implements ICrudService<RQ, RS, ID> {

        protected final JpaRepository<E, ID> repository;
        protected final GenericBaseMapper<E, RQ, RS> mapper;

        public CrudServiceImpl(JpaRepository<E, ID> repository, GenericBaseMapper<E, RQ, RS> mapper) {
            this.repository = repository;
            this.mapper = mapper;
        }

    @Override
    public RS create(RQ dto) {
        E entity = mapper.toEntity(dto);

        System.out.println("Entidad antes de persistir: " + entity);

        return mapper.toDto(repository.save(entity));
    }


    @Override
    public RS update(ID id, RQ dto) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("No se encontró el recurso con id " + id);
        }
        E entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }

    @Override
    public RS findById(ID id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Recurso no encontrado con id " + id));
    }

    @Override
    public List<RS> findAll() {

        List<E> entities = repository.findAll();

        System.out.println("Lista de entidades: " + entities);

        return mapper.toDtoList(entities);
    }

}
