package com.fluytcloud.api.transport.response;

import com.fluycloud.support.entities.PersonType;

public record PersonResponse(
        Integer id,
        String name,
        PersonType type,
        String cpfCnpj,
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
