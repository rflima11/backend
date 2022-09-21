package com.fluytcloud.api.transport.request;

import com.fluycloud.support.entities.PersonType;

public record PersonRequest(
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
