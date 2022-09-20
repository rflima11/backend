package com.fluytcloud.api.transport.mapper;

import com.fluytcloud.api.transport.request.GroupRequest;
import com.fluytcloud.api.transport.response.GroupResponse;
import com.fluytcloud.product.entities.Group;

public class GroupMapper {

    private GroupMapper() {}

    public static Group map(GroupRequest request) {
        return map(null, request);
    }

    public static Group map(Integer id, GroupRequest request) {
        return new Group(id, request.name());
    }

    public static GroupResponse map(Group group) {
        return new GroupResponse(group.id(), group.name());
    }

}
