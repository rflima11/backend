package transport.response;

import com.fluycloud.support.entities.PersonType;

public record PersonResponse(
        Integer id,
        String name,
        PersonType type,
        String cnpj,
        CityResponse city,
        String zipCode,
        String address,
        String addressNumber,
        String district,
        String complement,
        String phoneNumber,
        String email,
        String referencePoint
) {
}
