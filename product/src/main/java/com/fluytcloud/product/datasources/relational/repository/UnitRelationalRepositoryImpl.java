package com.fluytcloud.product.datasources.relational.repository;

import com.fluytcloud.product.datasources.relational.mapper.UnitModelMapper;
import com.fluytcloud.product.entities.Unit;
import com.fluytcloud.product.repositories.UnitRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UnitRelationalRepositoryImpl implements UnitRepository {

    private final UnitJpaRepository jpaRepository;

    public UnitRelationalRepositoryImpl(UnitJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Page<Unit> findAll(Pageable pageable) {
        var page = jpaRepository.findAll(pageable);
        return new PageImpl<>(
                page.getContent()
                        .stream()
                        .map(UnitModelMapper::map)
                        .toList(),
                page.getPageable(),
                page.getTotalElements()
        );
    }

    @Override
    public List<Unit> search(String name) {
        return jpaRepository.complete("%" + name + "%")
                .stream()
                .map(UnitModelMapper::map)
                .toList();
    }

    @Override
    public Optional<Unit> findById(Integer id) {
        return jpaRepository.findById(id).map(UnitModelMapper::map);
    }

    @Override
    public List<Unit> findAll() {
        return jpaRepository.findAll().stream().map(UnitModelMapper::map).toList();
    }
}
