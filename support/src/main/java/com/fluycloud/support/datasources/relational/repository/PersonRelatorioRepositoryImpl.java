package com.fluycloud.support.datasources.relational.repository;

import com.fluycloud.support.datasources.relational.mapper.PersonModelMapper;
import com.fluycloud.support.entities.Person;
import com.fluycloud.support.repositories.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class PersonRelatorioRepositoryImpl implements PersonRepository {

    private static final PersonModelMapper PERSON_MAPPER = PersonModelMapper.INSTANCE;
    private final PersonJpaRepository jpaRepository;

    public PersonRelatorioRepositoryImpl(PersonJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        var page = jpaRepository.findAll(pageable);
        return new PageImpl<>(
                page.getContent()
                        .stream()
                        .map(PERSON_MAPPER::map)
                        .toList(),
                page.getPageable(),
                page.getTotalElements()
        );
    }

    @Override
    public Optional<Person> findById(Integer id) {
        return jpaRepository.findById(id)
                .map(PERSON_MAPPER::map);
    }

    @Override
    public Person persist(Person person) {
        return PERSON_MAPPER.map(jpaRepository.save(PERSON_MAPPER.map(person)));
    }

    @Override
    public boolean exists(Integer id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public void delete(Integer id) {
        jpaRepository.deleteById(id);
    }
}
