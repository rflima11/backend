package transport.request;

import com.fluycloud.support.entities.PersonType;
import transport.response.CityRequest;

public record PersonRequest(
        Integer id,
        String name,
        PersonType type,
        String cpfCnpj,
        CityRequest city,
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
