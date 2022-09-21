package com.fluytcloud.auth.transport.http.filter;

import com.fluytcloud.auth.interactors.CompanyService;
import com.fluytcloud.auth.interactors.UserInfoService;
import com.fluytcloud.auth.transport.http.exception.ChooseCompanyException;
import com.fluytcloud.auth.transport.http.exception.ChooseOrganizationException;
import com.fluytcloud.auth.transport.http.exception.EmptyCompanyException;
import com.fluytcloud.auth.transport.http.exception.EmptyOrganizationException;
import com.fluytcloud.core.entities.UserInfoContext;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.util.function.Predicate;

@Provider
public class CompanyFilter implements ContainerRequestFilter {

    @Inject
    UserInfoService userInfoService;

    @Inject
    CompanyService companyService;

    private static final Predicate<ContainerRequestContext> ALLOWED_COMPANIES_ROUTE = value
            -> "/companies".equals(value.getUriInfo().getPath());

    private static final Predicate<ContainerRequestContext> ALLOWED_ORGANIZATIONS_ROUTE = value
            -> "/organizations".equals(value.getUriInfo().getPath());

    private static final Predicate<ContainerRequestContext> ALLOWED_FULL_AUTHENTICATION_ROUTE = value
            -> "/auth/full-authentication".equals(value.getUriInfo().getPath()) && "POST".equals(value.getMethod());

    private static final Predicate<ContainerRequestContext> ALLOWED_ROUTE = ALLOWED_ORGANIZATIONS_ROUTE
            .or(ALLOWED_COMPANIES_ROUTE)
            .or(ALLOWED_FULL_AUTHENTICATION_ROUTE);

    @Override
    public void filter(ContainerRequestContext containerRequestContext) {
        if (ALLOWED_ROUTE.test(containerRequestContext)) {
            return;
        }

        var userInfo = userInfoService.get();
        if (userInfo.isPresent()) {
            UserInfoContext.setCurrentTenant(userInfo.get());
            return;
        }

        var organizations = companyService.getUserOrganizations();
        if (organizations.size() == 0) {
            throw new EmptyOrganizationException();
        }

        if (organizations.size() > 1) {
            throw new ChooseOrganizationException();
        }

        var companies = companyService.getUserCompanies();
        if (companies.isEmpty()) {
            throw new EmptyCompanyException();
        }

        if (companies.size() > 1) {
            throw new ChooseCompanyException();
        }

        var organization = organizations.iterator().next();
        var company = companies.iterator().next();
        userInfoService.set(organization.identifier(), company);
    }

}