package com.fluytcloud.company.interactors;

import com.fluytcloud.company.entities.Customer;
import com.fluytcloud.company.repositories.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;
import java.util.Set;

@ApplicationScoped
public class CustomerService {

    @Inject CustomerRepository customerRepository;

    public Set<Customer> findByIdentifiers(Set<String> identifiers) {
        return customerRepository.findByIdentifiers(identifiers);
    }

    public Optional<Customer> getByIdentifier(String identifier) {
        return customerRepository.getByIdentifier(identifier);
    }

}
