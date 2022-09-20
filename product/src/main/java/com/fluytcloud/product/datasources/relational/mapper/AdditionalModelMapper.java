package com.fluytcloud.product.datasources.relational.mapper;

import com.fluycloud.support.core.CrudMapper;
import com.fluytcloud.product.datasources.relational.model.AdditionalModel;
import com.fluytcloud.product.entities.Additional;

public class AdditionalModelMapper implements CrudMapper<Additional, AdditionalModel> {

    @Override
    public Additional mapToEntity(AdditionalModel model) {
        return new Additional(model.getId(), model.getName(), model.getEnable());
    }

    @Override
    public AdditionalModel mapToModel(Additional object) {
        return new AdditionalModel()
                .setId(object.id())
                .setName(object.name())
                .setEnable(object.enable());
    }

}
