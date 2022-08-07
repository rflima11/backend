package com.fluytcloud.company.repositories;

import com.fluytcloud.company.entities.Customer;

import java.util.Set;

public interface CustomerRepository {

    Set<Customer> findByIdentifiers(Set<String> identifiers);

}