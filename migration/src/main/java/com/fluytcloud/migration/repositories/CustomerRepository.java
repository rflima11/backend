package com.fluytcloud.migration.repositories;

import com.fluytcloud.migration.entities.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

}
