package com.fluytcloud.api.transport.mapper;

import com.fluytcloud.api.transport.request.GroupRequest;
import com.fluytcloud.api.transport.response.GroupResponse;
import com.fluytcloud.product.entities.Group;

import java.util.HashSet;

public class GroupMapper {

    private GroupMapper() {}

    public static Group map(GroupRequest request) {
        var group = new Group(request.id(), request.name(), null, new HashSet<>(request.subgroups().size()));

        for (GroupRequest subgroup : request.subgroups()) {
            group.subgroups().add(new Group(subgroup.id(), subgroup.name(), group, null));
        }

        return group;
    }

    public static GroupResponse map(Group group) {
        var groupResponse = new GroupResponse(group.id(), group.name(), new HashSet<>(group.subgroups().size()));

        for (Group subgroup : group.subgroups()) {
            groupResponse.subgroups().add(new GroupResponse(subgroup.id(), subgroup.name(), null));
        }

        return groupResponse;
    }

}
