package com.fluytcloud.auth.interactors;

import com.fluytcloud.auth.repositories.GroupRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public boolean create(String group, String... subGroups) {
        return groupRepository.create(group, subGroups);
    }

}
