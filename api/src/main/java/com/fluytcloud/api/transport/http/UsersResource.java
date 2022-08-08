package com.fluytcloud.api.transport.http;

import com.fluytcloud.auth.interactors.CompanyService;
import io.quarkus.oidc.runtime.OidcJwtCallerPrincipal;
import io.quarkus.security.identity.SecurityIdentity;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api/users")
public class UsersResource {

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    CompanyService companyService;

    @GET
    @Path("/me")
    public User me() {
        var state = ((OidcJwtCallerPrincipal) securityIdentity.getPrincipal()).getClaim("session_state");
        System.out.println(state.toString());

        var companies = companyService.getUserCompanies();

        companies.forEach(System.out::println);

        return new User(securityIdentity);
    }

    public static class User {

        private final String userName;

        User(SecurityIdentity securityIdentity) {
            this.userName = securityIdentity.getPrincipal().getName();
        }

        public String getUserName() {
            return userName;
        }
    }
}