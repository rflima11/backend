package com.fluytcloud.product.datasources.relational.mapper;

import com.fluycloud.support.core.CrudMapper;
import com.fluytcloud.product.datasources.relational.model.GroupModel;
import com.fluytcloud.product.entities.Group;

import java.util.HashSet;

public class GroupModelMapper implements CrudMapper<Group, GroupModel> {

    @Override
    public Group mapToEntity(GroupModel model) {
        var group = new Group(model.getId(), model.getName(), null, new HashSet<>(model.getSubgroups().size()));

        for (GroupModel subgroup : model.getSubgroups()) {
            group.subgroups().add(new Group(subgroup.getId(), subgroup.getName(), group, null));
        }

        return group;
    }

    @Override
    public GroupModel mapToModel(Group group) {
        var groupModel = new GroupModel()
                .setId(group.id())
                .setName(group.name())
                .setSubgroups(new HashSet<>(group.subgroups().size()));

        for (Group subgroup : group.subgroups()) {
            groupModel.getSubgroups().add(new GroupModel()
                    .setId(subgroup.id())
                    .setName(subgroup.name())
                    .setGroup(groupModel));
        }

        return groupModel;
    }

}
