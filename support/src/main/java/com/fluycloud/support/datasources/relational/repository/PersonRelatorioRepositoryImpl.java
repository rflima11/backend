package com.fluycloud.support.datasources.relational.repository;

import com.fluycloud.support.datasources.relational.mapper.PersonModelMapper;
import com.fluycloud.support.entities.Person;
import com.fluycloud.support.repositories.PersonRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PersonRelatorioRepositoryImpl implements PersonRepository {

    private static final PersonModelMapper mapper = PersonModelMapper.INSTANCE;
    private final PersonJpaRepository jpaRepository;

    public PersonRelatorioRepositoryImpl(PersonJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Person> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::map)
                .toList();
    }

    @Override
    public Optional<Person> findById(Integer id) {
        return jpaRepository.findById(id)
                .map(mapper::map);
    }

    @Override
    public Person persist(Person person) {
        return mapper.map(jpaRepository.save(mapper.map(person)));
    }

}
