package com.fluycloud.support.interactors;

import com.fluycloud.support.entities.City;
import com.fluycloud.support.repositories.CityRepository;
import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> search(String name) {
        if (StringUtils.isBlank(name)) {
            return cityRepository.findAll();
        }
        return cityRepository.search(name);
    }

    public Optional<City> findById(Integer id) {
        return cityRepository.findById(id);
    }
}
