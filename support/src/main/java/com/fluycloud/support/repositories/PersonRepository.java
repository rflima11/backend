package com.fluycloud.support.repositories;

import com.fluycloud.support.entities.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {

    List<Person> findAll();

    Optional<Person> findById(Integer id);

    Person persist(Person person);

    boolean exists(Integer id);

}
