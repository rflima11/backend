package com.fluycloud.support.datasources.relational.mapper;

import com.fluycloud.support.datasources.relational.model.CityModel;
import com.fluycloud.support.entities.City;

public class CityMapper {

    public static City map(CityModel model) {
        return new City(model.getId(), model.getName(), model.getStateId());
    }

    public static CityModel map(City city) {
        return new CityModel().
                setId(city.id())
                .setName(city.name())
                .setStateId(city.stateId());
    }
}
