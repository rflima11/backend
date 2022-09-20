package com.fluycloud.support.interactors;

import com.fluycloud.support.core.CrudRepository;
import com.fluycloud.support.core.CrudServiceImpl;
import com.fluycloud.support.entities.Person;
import com.fluycloud.support.repositories.PersonRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonService extends CrudServiceImpl<Person, Integer> {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    protected CrudRepository<Person, Integer> getRepository() {
        return personRepository;
    }

}
