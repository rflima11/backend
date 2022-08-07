package com.fluytcloud.restaurante;

import com.fluytcloud.company.interactors.CustomerService;
import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.stream.Collectors;

@Path("/api/users")
public class UsersResource {

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    JsonWebToken jwt;

    @Inject
    CustomerService customerService;

    @GET
    @Path("/me")
    public User me() {
        var identifiers = jwt.getGroups()
                .stream()
                .filter(it -> it.startsWith("/clientes/"))
                .map(it -> it.split("/")[2])
                .collect(Collectors.toSet());

        var customers = customerService.findByIdentifiers(identifiers)
                .stream()
                .map(it -> new CompanyLoginResponse(it.name()))
                .toList();

        customers.forEach(System.out::println);


        jwt.getGroups().forEach(System.out::println);
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