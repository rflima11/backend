package com.fluycloud.support.repositories;

import com.fluycloud.support.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PersonRepository {

    Page<Person> findAll(Pageable pageable);

    Optional<Person> findById(Integer id);

    Person persist(Person person);

    boolean exists(Integer id);

    void delete(Integer id);

}
