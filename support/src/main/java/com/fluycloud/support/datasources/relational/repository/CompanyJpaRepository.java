package com.fluycloud.support.datasources.relational.repository;

import com.fluycloud.support.datasources.relational.model.CompanyModel;
import com.fluycloud.support.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyJpaRepository extends JpaRepository<CompanyModel,Integer> {
    Optional<CompanyModel> findByCnpj(String cnpj);
}
