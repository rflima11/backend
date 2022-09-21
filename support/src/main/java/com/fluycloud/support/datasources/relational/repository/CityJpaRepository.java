package com.fluycloud.support.datasources.relational.repository;

import com.fluycloud.support.datasources.relational.model.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityJpaRepository extends JpaRepository<CityModel, Integer> {
    List<CityModel> findByNameContainingIgnoreCase(String name);
}
