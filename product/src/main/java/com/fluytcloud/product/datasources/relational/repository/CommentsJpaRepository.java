package com.fluytcloud.product.datasources.relational.repository;

import com.fluytcloud.product.datasources.relational.model.CommentsModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsJpaRepository extends JpaRepository<CommentsModel, Integer> {

    List<CommentsModel> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
