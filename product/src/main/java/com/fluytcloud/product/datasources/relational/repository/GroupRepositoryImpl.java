package com.fluytcloud.product.datasources.relational.repository;

import com.fluytcloud.product.datasources.relational.mapper.GroupModelMapper;
import com.fluytcloud.product.entities.Group;
import com.fluytcloud.product.repositories.GroupRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class GroupRepositoryImpl implements GroupRepository {
    private final GroupJpaRepository jpaRepository;

    public GroupRepositoryImpl(GroupJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Page<Group> findAll(Pageable pageable) {
        var page = jpaRepository.findAll(pageable);
        return new PageImpl<>(
                page.getContent()
                        .stream()
                        .map(GroupModelMapper::map)
                        .toList(),
                page.getPageable(),
                page.getTotalElements()
        );
    }

    @Override
    public Optional<Group> findById(Integer id) {
        return jpaRepository.findById(id)
                .map(GroupModelMapper::map);
    }

    @Override
    public Group persist(Group group) {
        return GroupModelMapper.map(jpaRepository.save(GroupModelMapper.map(group)));
    }

    @Override
    public boolean exists(Integer id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public void delete(Integer id) {
        jpaRepository.deleteById(id);
    }

}
