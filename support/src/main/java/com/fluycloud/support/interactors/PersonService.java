package com.fluycloud.support.interactors;

import com.fluycloud.support.entities.DuplicatedCnpjException;
import com.fluycloud.support.entities.EntityNotFound;
import com.fluycloud.support.entities.Person;
import com.fluycloud.support.repositories.PersonRepository;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
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

    public Person update(Person person) {
        var exists = personRepository.exists(person.getId());
        if (!exists) {
            throw new EntityNotFound("Person " + person.getId() + " not found");
        }
        return create(person);
    }

    public void delete(Integer id) {
        var exists = personRepository.exists(id);
        if (!exists) {
            throw new EntityNotFound("Person " + id + " not found");
        }
        personRepository.delete(id);
    }
}
