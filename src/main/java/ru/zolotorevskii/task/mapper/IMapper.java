package ru.zolotorevskii.task.mapper;

import ru.zolotorevskii.task.entity.AbstractEntity;

public interface IMapper<E extends AbstractEntity, DTO> {
    E toEntity(DTO dto);

    DTO toDto(E entity);
}