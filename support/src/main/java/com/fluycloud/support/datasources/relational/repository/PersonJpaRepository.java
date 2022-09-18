package com.fluycloud.support.datasources.relational.repository;

import com.fluycloud.support.datasources.relational.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<PersonModel, Integer> {
}
