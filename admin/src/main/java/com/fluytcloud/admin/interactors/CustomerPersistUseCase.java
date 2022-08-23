package com.fluytcloud.admin.interactors;

import com.fluytcloud.admin.entities.Customer;
import com.fluytcloud.admin.repositories.CustomerRepository;
import com.fluytcloud.admin.util.StringUtil;
import com.fluytcloud.auth.entities.User;
import com.fluytcloud.auth.interactors.GroupService;
import com.fluytcloud.auth.interactors.UserService;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CustomerPersistUseCase {

    private final CustomerRepository customerRepository;
    private final UserService userService;
    private final GroupService groupService;

    public CustomerPersistUseCase(
            CustomerRepository customerRepository,
            UserService userService,
            GroupService groupService) {
        this.customerRepository = customerRepository;
        this.userService = userService;
        this.groupService = groupService;
    }

    public void create(Customer customer) {
        customerRepository.create(customer);

        var subGroup = StringUtil.stripAccents(customer.getAddress());

        groupService.create(customer.getSchemaName(), subGroup);

        userService.create(new User(
                customer.getEmail(),
                customer.getTradeName(),
                customer.getSchemaName(),
                List.of(subGroup)
        ));
    }

}
