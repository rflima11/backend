package com.fluytcloud.product.datasources.relational.mapper;

import com.fluytcloud.product.datasources.relational.model.GroupModel;
import com.fluytcloud.product.entities.Group;

public class GroupModelMapper {

    private GroupModelMapper() {}

    public static Group map(GroupModel model) {
        return new Group(model.getId(), model.getName());
    }

    public static GroupModel map(Group group) {
        return new GroupModel()
                .setId(group.id())
                .setName(group.name());
    }

}
