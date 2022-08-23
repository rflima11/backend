package com.fluytcloud.admin.repositories;


import com.fluytcloud.admin.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    void create(Customer customer);

}
