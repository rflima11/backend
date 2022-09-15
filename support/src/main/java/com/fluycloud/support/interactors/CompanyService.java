package com.fluycloud.support.interactors;

import com.fluycloud.support.entities.Company;
import com.fluycloud.support.repositories.CompanyRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Optional<Company> findById(Integer id) {
        return companyRepository.findById(id);
    }

    public Company create(Company company) {
        return companyRepository.persist(company);
    }
}
