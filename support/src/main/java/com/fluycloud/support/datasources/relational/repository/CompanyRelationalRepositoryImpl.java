package com.fluycloud.support.datasources.relational.repository;

import com.fluycloud.support.datasources.relational.mapper.CompanyModelMapper;
import com.fluycloud.support.entities.Company;
import com.fluycloud.support.repositories.CompanyRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CompanyRelationalRepositoryImpl implements CompanyRepository {
    private static final CompanyModelMapper mapper = CompanyModelMapper.INSTANCE;
    private final CompanyJpaRepository jpaRepository;
    public CompanyRelationalRepositoryImpl(CompanyJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    @Override
    public List<Company> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::map)
                .toList();
    }

    @Override
    public Optional<Company> findById(Integer id) {
        return jpaRepository.findById(id)
                .map(mapper::map);
    }

    @Override
    public Company persist(Company company) {
        return mapper.map(jpaRepository.save(mapper.map(company)));
    }
}
