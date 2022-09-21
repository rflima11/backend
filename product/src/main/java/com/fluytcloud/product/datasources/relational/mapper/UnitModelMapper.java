package com.fluytcloud.product.datasources.relational.mapper;

import com.fluytcloud.product.datasources.relational.model.UnitModel;
import com.fluytcloud.product.entities.Unit;

public class UnitModelMapper {

    private UnitModelMapper() {}

    public static Unit map(UnitModel model) {
        return new Unit(model.getId(), model.getInitials(), model.getDescription(), model.getInitialsNfe());
    }

}
