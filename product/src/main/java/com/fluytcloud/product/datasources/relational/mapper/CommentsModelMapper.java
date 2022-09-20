package com.fluytcloud.product.datasources.relational.mapper;

import com.fluycloud.support.core.CrudMapper;
import com.fluytcloud.product.datasources.relational.model.CommentsModel;
import com.fluytcloud.product.entities.Comments;

public class CommentsModelMapper implements CrudMapper<Comments, CommentsModel> {

    @Override
    public Comments mapToEntity(CommentsModel model) {
        return new Comments(model.getId(), model.getName(), model.getEnable());
    }

    @Override
    public CommentsModel mapToModel(Comments object) {
        return new CommentsModel()
                .setId(object.id())
                .setName(object.name())
                .setEnable(object.enable());
    }

}
