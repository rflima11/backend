package com.fluytcloud.product.datasources.relational.repository;

import com.fluytcloud.product.datasources.relational.model.AdditionalModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdditionalJpaRepository extends JpaRepository<AdditionalModel, Integer> {

    List<AdditionalModel> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
