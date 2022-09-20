package com.fluytcloud.product.datasources.relational.repository;

import com.fluytcloud.product.datasources.relational.model.GroupModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupJpaRepository extends JpaRepository<GroupModel, Integer> {
}
