package com.fluytcloud.api.transport.response;

public record PersonListResponse(
        Integer id,
        String name,
        String cpfCnpj
) {
}
