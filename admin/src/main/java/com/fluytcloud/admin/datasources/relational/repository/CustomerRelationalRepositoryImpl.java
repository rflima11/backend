package com.fluytcloud.admin.datasources.relational.repository;

import com.fluytcloud.admin.datasources.relational.mapper.CustomerModelMapper;
import com.fluytcloud.admin.datasources.relational.model.CustomerModel;
import com.fluytcloud.admin.entities.Customer;
import com.fluytcloud.admin.repositories.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CustomerRelationalRepositoryImpl implements CustomerRepository {

    private static final CustomerModelMapper CUSTOMER_MODEL_MAPPER = new CustomerModelMapper();
    private final EntityManager entityManager;

    public CustomerRelationalRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Customer> findAll() {
        return entityManager
                .createQuery("select c from CustomerModel c", CustomerModel.class)
                .getResultList()
                .stream()
                .map(CUSTOMER_MODEL_MAPPER::map)
                .toList();
    }

}
