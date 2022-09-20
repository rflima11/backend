package com.fluytcloud.product.datasources.relational.repository;

import com.fluycloud.support.core.CrudMapper;
import com.fluycloud.support.core.CrudRepositoryImpl;
import com.fluytcloud.product.datasources.relational.mapper.GroupModelMapper;
import com.fluytcloud.product.datasources.relational.model.GroupModel;
import com.fluytcloud.product.entities.Group;
import com.fluytcloud.product.repositories.GroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GroupRepositoryImpl extends CrudRepositoryImpl<Group, GroupModel, Integer> implements GroupRepository {
    private final GroupJpaRepository jpaRepository;

    public GroupRepositoryImpl(GroupJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    protected JpaRepository<GroupModel, Integer> getJpaRepository() {
        return jpaRepository;
    }

    @Override
    protected CrudMapper<Group, GroupModel> getMapper() {
        return new GroupModelMapper();
    }
}
