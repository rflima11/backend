package com.fluytcloud.product.datasources.relational.repository;

import com.fluytcloud.product.datasources.relational.model.CommentsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsJpaRepository extends JpaRepository<CommentsModel, Integer> {
}
