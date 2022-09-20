package com.fluytcloud.product.datasources.relational.mapper;

import com.fluycloud.support.core.CrudMapper;
import com.fluytcloud.product.datasources.relational.model.GroupModel;
import com.fluytcloud.product.entities.Group;

public class GroupModelMapper implements CrudMapper<Group, GroupModel> {

    @Override
    public Group mapToEntity(GroupModel model) {
        return new Group(model.getId(), model.getName());
    }

    @Override
    public GroupModel mapToModel(Group group) {
        return new GroupModel()
                .setId(group.id())
                .setName(group.name());
    }

}
