package com.fluytcloud.api.transport.mapper;

import com.fluytcloud.api.transport.request.AdditionalRequest;
import com.fluytcloud.api.transport.response.AdditionalResponse;
import com.fluytcloud.product.entities.Additional;

public class AdditionalMapper {

    private AdditionalMapper() {}

    public static Additional map(AdditionalRequest request) {
        return map(null, request);
    }

    public static Additional map(Integer id, AdditionalRequest request) {
        return new Additional(id, request.name(), request.enable());
    }

    public static AdditionalResponse map(Additional additional) {
        return new AdditionalResponse(additional.id(), additional.name(), additional.enable());
    }

}
