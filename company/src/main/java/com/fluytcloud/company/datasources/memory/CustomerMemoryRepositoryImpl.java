package com.fluytcloud.company.datasources.memory;

import com.fluytcloud.company.entities.Customer;
import com.fluytcloud.company.repositories.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerMemoryRepositoryImpl implements CustomerRepository {

    private final List<Customer> customers;

    public CustomerMemoryRepositoryImpl() {
        this.customers = List.of(
                new Customer(1L, "Grimpa Burguer", "grimpa"),
                new Customer(2L, "Bombar Avenida", "bombar"),
                new Customer(3L, "Pato Lanches", "pato_lanches")
        );
    }

    @Override
    public Set<Customer> findByIdentifiers(Set<String> identifiers) {
        return customers.stream()
                .filter(it -> identifiers.contains(it.identifier()))
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<Customer> getByIdentifier(String identifier) {
        return customers.stream()
                .filter(it -> it.identifier().equals(identifier))
                .findFirst();
    }

}
