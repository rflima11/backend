package com.fluytcloud.restaurante;

import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api/users")
public class UsersResource {

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    JsonWebToken jwt;

    @GET
    @Path("/me")
    public User me() {
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