package com.fluytcloud.admin.transport.response;

public record CustomerResponse(
        Integer id,
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
