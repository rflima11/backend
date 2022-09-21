package com.fluytcloud.product.repositories;

import com.fluytcloud.product.entities.Unit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UnitRepository {

    Page<Unit> findAll(Pageable pageable);

    List<Unit> search(String search);

    Optional<Unit> findById(Integer id);

    List<Unit> findAll();


}
