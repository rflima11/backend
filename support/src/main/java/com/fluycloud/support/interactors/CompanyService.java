package com.fluycloud.support.interactors;

import com.fluycloud.support.entities.Company;
import com.fluycloud.support.entities.DuplicatedCnpj;
import com.fluycloud.support.repositories.CompanyRepository;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CompanyService {

   // private static final Logger LOG = Logger.getLogger(CompanyService.class);

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
        try {
            return companyRepository.persist(company);
        } catch (Exception exception) {
            //LOG.error("Erro ao persistir Filial", exception);
            if (ExceptionUtils.getStackTrace(exception)
                    .contains("ConstraintViolationException")) {
                throw new DuplicatedCnpj();
            }
            throw exception;
        }

    }
}
