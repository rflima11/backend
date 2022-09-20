package com.fluytcloud.product.repositories;

import com.fluytcloud.product.entities.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GroupRepository {

    Page<Group> findAll(Pageable pageable);

    Optional<Group> findById(Integer id);

    Group persist(Group group);

    boolean exists(Integer id);

    void delete(Integer id);

}
