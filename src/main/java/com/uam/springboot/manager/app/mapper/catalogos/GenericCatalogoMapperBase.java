package com.uam.springboot.manager.app.mapper.catalogos;

import com.uam.springboot.manager.app.model.catalogos.Identifiable;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

public abstract class GenericCatalogoMapperBase<
        E extends Identifiable,
        RQ,
        RS> {

    @Mapping(source = "id", target = "id")
    public abstract RS toDto(E entity);

    public abstract E toEntity(RQ dto);

    public List<RS> toDtoList(List<E> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<E> toEntityList(List<RQ> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}