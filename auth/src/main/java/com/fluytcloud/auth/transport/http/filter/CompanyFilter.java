package com.fluytcloud.auth.transport.http.filter;

import com.fluytcloud.auth.entities.UserInfo;
import com.fluytcloud.auth.entities.UserInfoContext;
import com.fluytcloud.auth.interactors.CompanyService;
import com.fluytcloud.auth.interactors.UserInfoService;
import com.fluytcloud.auth.transport.http.exception.ChooseCompanyException;
import com.fluytcloud.auth.transport.http.exception.EmptyCompanyException;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CompanyFilter implements ContainerRequestFilter {

    @Inject
    UserInfoService userInfoService;

    @Inject
    CompanyService companyService;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        if ("/companies".equals(containerRequestContext.getUriInfo().getPath())
                || "/auth/full-authentication".equals(containerRequestContext.getUriInfo().getPath())) {
            return;
        }

        var userInfo = userInfoService.get();
        if (userInfo.isPresent()) {
            UserInfoContext.setCurrentTenant(userInfo.get());
            return;
        }

        var companies = companyService.getUserCompanies();
        if (companies.size() == 0) {
            throw new EmptyCompanyException();
        }

        if (companies.size() > 1) {
            throw new ChooseCompanyException();
        }

        var company = companies.iterator().next();
        userInfoService.set(new UserInfo(company.id()));
    }

}