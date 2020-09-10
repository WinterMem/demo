package com.pch.log.mapper;

import java.util.List;

/**
 * @author: pch
 * @date: 2020/9/10
 */
public interface BaseMapper<D, E> {
    /**
     * DTO转Entity
     * @param dto /
     * @return /
     */
    E toEntity(D dto);

    /**
     * Entity转DTO
     * @param entity /
     * @return /
     */
    D toDto(E entity);

    /**
     * DTO集合转Entity集合
     * @param dtoList /
     * @return /
     */
    List<E> toEntity(List<D> dtoList);

    /**
     * Entity集合转DTO集合
     * @param entityList /
     * @return /
     */
    List <D> toDto(List<E> entityList);
}
