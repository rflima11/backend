package com.fluytcloud.api.transport.request;

public record CompanyRequest(
        Integer id,
        String companyName,
        String tradeName,
        String cnpj,
        CityRequest city,
        String zipCode,
        String address,
        String addressNumber,
        String district,
        String complement,
        String phoneNumber,
        String email,
        String stateRegister,
        String municipalRegister
){}
