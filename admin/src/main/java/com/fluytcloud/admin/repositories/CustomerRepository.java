package com.fluytcloud.admin.repositories;


import com.fluytcloud.admin.entities.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

}
