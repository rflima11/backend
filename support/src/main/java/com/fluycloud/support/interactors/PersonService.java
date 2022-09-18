package com.fluycloud.support.interactors;

import com.fluycloud.support.entities.DuplicatedCnpjException;
import com.fluycloud.support.entities.Person;
import com.fluycloud.support.repositories.PersonRepository;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(Integer id) {
        return personRepository.findById(id);
    }

    public Person create(Person person) {
        try {
            return personRepository.persist(person);
        } catch (Exception exception) {
            if (ExceptionUtils.getStackTrace(exception).contains("ConstraintViolationException")) {
                throw new DuplicatedCnpjException();
            }
            throw exception;
        }
    }

}
