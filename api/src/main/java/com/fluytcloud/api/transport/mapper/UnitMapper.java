package com.fluytcloud.api.transport.mapper;

import com.fluytcloud.api.transport.response.UnitResponse;
import com.fluytcloud.product.entities.Unit;

public class UnitMapper {

    private UnitMapper() {}

    public static UnitResponse map(Unit unit) {
        return new UnitResponse(unit.id(), unit.initials(), unit.description());
    }

}
