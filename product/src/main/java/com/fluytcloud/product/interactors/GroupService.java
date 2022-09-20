package com.fluytcloud.product.interactors;

import com.fluytcloud.product.entities.Group;
import com.fluytcloud.product.repositories.GroupRepository;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@ApplicationScoped
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Page<Group> findAll(Pageable pageable) {
        return groupRepository.findAll(pageable);
    }

    public Optional<Group> findById(Integer id) {
        return groupRepository.findById(id);
    }

    public Group create(Group group) {
        try {
            return groupRepository.persist(group);
        } catch (Exception exception) {
            if (ExceptionUtils.getStackTrace(exception).contains("ConstraintViolationException")) {
                //throw new Duplicate();
            }
            throw exception;
        }
    }

    public Group update(Group group) {
        var exists = groupRepository.exists(group.id());
        if (!exists) {
            throw new EntityNotFoundException("Group " + group.id() + " not found");
        }
        return create(group);
    }

    public void delete(Integer id) {
        var exists = groupRepository.exists(id);
        if (!exists) {
            throw new EntityNotFoundException("Group " + id + " not found");
        }
        groupRepository.delete(id);
    }


}
