package com.fluytcloud.restaurante;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    private final PersonData personData;

    public PersonRepositoryImpl(PersonData personData) {
        this.personData = personData;
    }

    @Override
    public List<Person> findAll() {
        return personData.findAll();
    }
}
