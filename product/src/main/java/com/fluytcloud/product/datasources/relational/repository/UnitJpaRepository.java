package com.fluytcloud.product.datasources.relational.repository;

import com.fluytcloud.product.datasources.relational.model.UnitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UnitJpaRepository extends JpaRepository<UnitModel, Integer> {

    @Query("select u from UnitModel u where lower(u.initials) like :search or lower(u.description) like :search")
    List<UnitModel> complete(@Param("search") String search);

}
