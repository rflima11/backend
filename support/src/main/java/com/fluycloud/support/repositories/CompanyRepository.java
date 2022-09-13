package com.fluycloud.support.repositories;

import com.fluycloud.support.entities.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {

    List<Company> findAll();

    Optional<Company> findById(Integer id);

    Company persist(Company company);

}
