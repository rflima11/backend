package com.fluytcloud.restaurante;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonUseCase {

    private PersonRepository personRepository;

    public PersonUseCase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
