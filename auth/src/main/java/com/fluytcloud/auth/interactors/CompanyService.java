package com.fluytcloud.auth.interactors;

import com.fluytcloud.auth.entities.Company;
import com.fluytcloud.company.interactors.CustomerService;
import com.fluytcloud.security.entities.Group;
import com.fluytcloud.security.interactors.GroupService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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
                .map(it -> new Company(it.name()))
                .collect(Collectors.toSet());
    }

}
