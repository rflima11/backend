package com.fluytcloud.auth.interactors;

import com.fluytcloud.auth.entities.Company;
import com.fluytcloud.company.interactors.CustomerService;
import com.fluytcloud.security.entities.Group;
import com.fluytcloud.security.interactors.GroupService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class CompanyService {

    @Inject
    CustomerService customerService;

    @Inject
    GroupService groupService;

    public Set<Company> getUserCompanies() {
        var identifiers= groupService.getUserCompanies()
                .stream()
                .map(Group::name)
                .collect(Collectors.toSet());

        return customerService.findByIdentifiers(identifiers)
                .stream()
                .map(it -> new Company(it.id(), it.name(), it.identifier()))
                .collect(Collectors.toSet());
    }

    public Optional<Company> getUserCompanyByIdentifier(String identifier) {
        var exists = groupService.getUserCompanies()
                .stream()
                .anyMatch(it -> it.name().equals(identifier));
        if (exists) {
            return getByIdentifier(identifier);
        }

        return Optional.empty();
    }

    public Optional<Company> getByIdentifier(String identifier) {
        return customerService.getByIdentifier(identifier)
                .map(it -> new Company(it.id(), it.name(), it.identifier()));
    }

}
