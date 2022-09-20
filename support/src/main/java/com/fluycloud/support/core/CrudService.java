package com.fluycloud.support.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CrudService<T, ID> {

    Page<T> findAll(Pageable pageable);

    Optional<T> findById(ID id);

    T create(T object);

    T update(ID id, T object);

    void delete(ID id);

}
