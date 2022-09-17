package com.fluycloud.support.repositories;

import com.fluycloud.support.entities.City;

import java.util.List;
import java.util.Optional;

public interface CityRepository {

    List<City> search(String name);

    Optional<City> findById(Integer id);

    List<City> findAll();

}
