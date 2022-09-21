package com.fluytcloud.api.transport.mapper;

import com.fluycloud.support.entities.City;
import com.fluytcloud.api.transport.request.CityRequest;
import com.fluytcloud.api.transport.response.CityResponse;

public class CityMapper {

    private CityMapper() {}
    public static CityResponse map(City city) {
        return new CityResponse(city.id(), city.name(), city.stateId());
    }

    public static City map(CityRequest request) {
        return new City(request.id(), request.name(), null);
    }
}
