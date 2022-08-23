package com.fluytcloud.admin.interactors;

import com.fluytcloud.admin.entities.Customer;
import com.fluytcloud.admin.repositories.CustomerRepository;
import com.fluytcloud.admin.util.StringUtil;
import com.fluytcloud.auth.entities.Group;
import com.fluytcloud.auth.entities.User;
import com.fluytcloud.auth.interactors.GroupService;
import com.fluytcloud.auth.interactors.UserService;
import com.fluytcloud.migration.interactors.MigrationUseCase;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@ApplicationScoped
public class CustomerPersistUseCase {

    private final CustomerRepository customerRepository;
    private final UserService userService;
    private final GroupService groupService;
    private final MigrationUseCase migrationUseCase;

    public CustomerPersistUseCase(
            CustomerRepository customerRepository,
            UserService userService,
            GroupService groupService,
            MigrationUseCase migrationUseCase) {
        this.customerRepository = customerRepository;
        this.userService = userService;
        this.groupService = groupService;
        this.migrationUseCase = migrationUseCase;
    }

    public void create(Customer customer) {
        customerRepository.create(customer);

        var subGroups = Stream.of(StringUtil.stripAccents(customer.getAddress()))
                .map(it -> new Group(it, Collections.emptyList()))
                .toList();

        var group = new Group(customer.getSchemaName(), subGroups);
        groupService.create(group);

        userService.create(new User(
                customer.getEmail(),
                customer.getTradeName(),
                List.of(group)
        ));

        migrationUseCase.migration(customer.getSchemaName());
    }

}
