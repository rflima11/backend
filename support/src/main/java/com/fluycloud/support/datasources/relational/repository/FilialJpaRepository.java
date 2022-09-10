package com.fluycloud.support.datasources.relational.repository;

import com.fluycloud.support.datasources.relational.model.FilialModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilialJpaRepository extends JpaRepository<FilialModel,Integer> {
}
