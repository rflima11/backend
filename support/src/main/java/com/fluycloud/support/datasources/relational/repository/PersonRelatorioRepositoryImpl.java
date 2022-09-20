package com.fluycloud.support.datasources.relational.repository;

import com.fluycloud.support.core.CrudMapper;
import com.fluycloud.support.core.CrudRepositoryImpl;
import com.fluycloud.support.datasources.relational.mapper.PersonModelMapper;
import com.fluycloud.support.datasources.relational.model.PersonModel;
import com.fluycloud.support.entities.Person;
import com.fluycloud.support.repositories.PersonRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRelatorioRepositoryImpl extends CrudRepositoryImpl<Person, PersonModel, Integer> implements PersonRepository {
    private final PersonJpaRepository jpaRepository;

    public PersonRelatorioRepositoryImpl(PersonJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    protected JpaRepository<PersonModel, Integer> getJpaRepository() {
        return jpaRepository;
    }

    @Override
    protected CrudMapper<Person, PersonModel> getMapper() {
        return new PersonModelMapper();
    }
}
