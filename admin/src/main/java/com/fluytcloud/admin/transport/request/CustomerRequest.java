package com.fluytcloud.admin.transport.request;

public record CustomerRequest(
        String companyName,
        String tradeName,
        String cnpj,
        String cep,
        Integer cityId,
        String address,
        String addressNumber,
        String district,
        String complement,
        String phoneNumber,
        String email,
        boolean active
) {
}
