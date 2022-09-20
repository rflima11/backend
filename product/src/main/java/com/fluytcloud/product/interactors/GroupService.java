package com.fluytcloud.product.interactors;

import com.fluycloud.support.core.CrudRepository;
import com.fluycloud.support.core.CrudServiceImpl;
import com.fluytcloud.product.entities.Group;
import com.fluytcloud.product.repositories.GroupRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GroupService extends CrudServiceImpl<Group, Integer> {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    @Override
    protected CrudRepository<Group, Integer> getRepository() {
        return groupRepository;
    }

}
