package com.uam.springboot.manager.app.service.impl.catalogos;

import com.uam.springboot.manager.app.mapper.GenericBaseMapper;
import com.uam.springboot.manager.app.model.Identifiable;
import com.uam.springboot.manager.app.repository.RepositoryRegistry;
import com.uam.springboot.manager.app.service.interfaces.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

    public class CrudServiceImpl<E extends Identifiable, RQ, RS, ID> implements ICrudService<RQ, RS, ID> {

        protected final JpaRepository<E, ID> repository;
        protected final GenericBaseMapper<E, RQ, RS> mapper;
        @Autowired
        protected RepositoryRegistry repositoryRegistry;

        public CrudServiceImpl(JpaRepository<E, ID> repository, GenericBaseMapper<E, RQ, RS> mapper) {
            this.repository = repository;
            this.mapper = mapper;
        }

    @Override
    public RS create(RQ dto) {
        E entity = mapper.toEntity(dto);

        System.out.println("Entidad antes de persistir: " + entity);

        loadRelations(dto, entity);

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

    protected void loadRelations(RQ dto, E entity) {
        Field[] dtoFields = dto.getClass().getDeclaredFields();

        for (Field dtoField : dtoFields) {
            try {
                dtoField.setAccessible(true);
                Object value = dtoField.get(dto);

                if (value == null) continue;

                String fieldName = dtoField.getName();
                Field entityField;
                try {
                    entityField = entity.getClass().getDeclaredField(fieldName.replace("Ids", ""));
                } catch (NoSuchFieldException e) {
                    continue; // Si no existe en la entidad, no hacemos nada
                }

                entityField.setAccessible(true);

                // Caso 1: Set<Long> → Set<Entidad>
                if (value instanceof Set<?> idSet) {
                    Set<Long> ids = (Set<Long>) idSet;
                    if (!ids.isEmpty()) {
                        Class<?> relationClass = getRelationClass(entityField);
                        JpaRepository repository = repositoryRegistry.getRepository(relationClass);
                        if (repository != null) {
                            Set<Object> relatedEntities = new HashSet<>(repository.findAllById(ids));
                            entityField.set(entity, relatedEntities);
                        }
                    }
                }
                // Caso 2: Long → Entidad (ManyToOne)
                else if (value instanceof Long id) {
                    Class<?> relationClass = getRelationClass(entityField);
                    JpaRepository repository = repositoryRegistry.getRepository(relationClass);
                    if (repository != null) {
                        Object relatedEntity = repository.findById(id).orElseThrow(
                                () -> new IllegalArgumentException("No existe el recurso relacionado para id=" + id)
                        );
                        entityField.set(entity, relatedEntity);
                    }
                }

            } catch (Exception ex) {
                throw new RuntimeException("Error cargando relaciones dinámicamente en CrudServiceImpl", ex);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Class<?> getRelationClass(Field entityField) {
        if (Set.class.isAssignableFrom(entityField.getType())) {
            // Es un Set<Algo>
            ParameterizedType type = (ParameterizedType) entityField.getGenericType();
            return (Class<?>) type.getActualTypeArguments()[0];
        } else {
            // Es un simple objeto
            return entityField.getType();
        }
    }
}
