package com.fluytcloud.admin.interactors;

import com.fluytcloud.admin.entities.Customer;
import com.fluytcloud.admin.repositories.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Set<String> getSchemaNames() {
        return customerRepository.findAll()
                .stream()
                .map(Customer::getSchemaName)
                .collect(Collectors.toSet());
    }

}
