package com.fluycloud.support.datasources.relational.repository;

import com.fluycloud.support.datasources.relational.mapper.FilialModelMapper;
import com.fluycloud.support.entities.Filial;
import com.fluycloud.support.repositories.FilialRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class FilialRelationalRepositoryImpl implements FilialRepository {
    private static final FilialModelMapper mapper = FilialModelMapper.INSTANCE;
    private final FilialJpaRepository jpaRepository;

    public FilialRelationalRepositoryImpl(FilialJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Filial> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::map)
                .toList();
    }

    @Override
    public Optional<Filial> findById(Integer id) {
        return jpaRepository.findById(id)
                .map(mapper::map);
    }

    @Override
    public Filial persist(Filial filial) {
        return mapper.map(jpaRepository.save(mapper.map(filial)));
    }
}
