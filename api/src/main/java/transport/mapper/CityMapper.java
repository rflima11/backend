package transport.mapper;

import com.fluycloud.support.entities.City;
import transport.response.CityRequest;
import transport.response.CityResponse;

public class CityMapper {

    public static CityResponse map(City city) {
        return new CityResponse(city.id(), city.name(), city.stateId());
    }

    public static City map(CityRequest request) {
        return new City(request.id(), request.name(), null);
    }
}
