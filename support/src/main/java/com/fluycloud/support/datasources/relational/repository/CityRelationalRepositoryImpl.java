package com.fluycloud.support.datasources.relational.repository;

import com.fluycloud.support.datasources.relational.mapper.CityMapper;
import com.fluycloud.support.entities.City;
import com.fluycloud.support.repositories.CityRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CityRelationalRepositoryImpl implements CityRepository {

    private final CityJpaRepository jpaRepository;

    public CityRelationalRepositoryImpl(CityJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<City> search(String name) {
        return jpaRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(CityMapper::map)
                .toList();
    }

    @Override
    public Optional<City> findById(Integer id) {
        return jpaRepository.findById(id).map(CityMapper::map);
    }

    @Override
    public List<City> findAll() {
        return jpaRepository.findAll().stream().map(CityMapper::map).toList();
    }
}
