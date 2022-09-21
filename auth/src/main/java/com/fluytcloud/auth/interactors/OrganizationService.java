package com.fluytcloud.auth.interactors;

import com.fluytcloud.core.entities.Organization;
import com.fluytcloud.security.entities.Group;
import com.fluytcloud.security.interactors.GroupService;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class OrganizationService {

    private final CustomerService customerService;

    private final GroupService groupService;

    public OrganizationService(CustomerService customerService, GroupService groupService) {
        this.customerService = customerService;
        this.groupService = groupService;
    }

    public Set<Organization> getUserOrganizations() {
        var identifiers= groupService.getUserCompanies()
                .stream()
                .map(Group::name)
                .collect(Collectors.toSet());

        return customerService.findBySchemasName(identifiers)
                .stream()
                .map(it -> new Organization(it.id(), it.name(), it.identifier()))
                .collect(Collectors.toSet());
    }

    public Optional<Organization> getUserOrganizationBySchemaName(String schemaName) {
        var exists = groupService.getUserCompanies()
                .stream()
                .anyMatch(it -> it.name().equals(schemaName));
        if (exists) {
            return getBySchemaName(schemaName);
        }

        return Optional.empty();
    }

    public Optional<Organization> getBySchemaName(String schemaName) {
        return customerService.getBySchemaName(schemaName)
                .map(it -> new Organization(it.id(), it.name(), it.identifier()));
    }
}
