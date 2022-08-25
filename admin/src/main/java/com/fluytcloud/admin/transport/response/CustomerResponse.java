package com.fluytcloud.admin.transport.response;

public record CustomerResponse(
        Integer id,
        String companyName,
        String tradeName,
        String cnpj,
        Integer cityId,
        String address,
        String addressNumber,
        String district,
        String complement,
        String phoneNumber,
        String email
) {
}
