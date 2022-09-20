package com.fluytcloud.product.datasources.relational.repository;

import com.fluytcloud.product.datasources.relational.model.AdditionalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdditionalJpaRepository extends JpaRepository<AdditionalModel, Integer> {
}
