package com.fluytcloud.admin.datasources.relational.repository;

import com.fluytcloud.admin.datasources.relational.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<CustomerModel, Integer> {
}
