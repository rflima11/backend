package com.fluytcloud.security.interactors;

import com.fluytcloud.security.entities.Group;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class GroupService {

    @Inject JsonWebToken jwt;

    private static final String KEYCLOAK_GROUP = "/clientes/";
    private static final int KEYCLOAK_GROUP_INDEX_COMPANY = 2;

    private static final String KEYCLOAK_GROUP_CHAR_SEPARATOR = "/";

    public Set<Group> getUserCompanies() {
        return jwt.getGroups()
                .stream()
                .filter(it -> it.startsWith(KEYCLOAK_GROUP)
                        && it.split(KEYCLOAK_GROUP_CHAR_SEPARATOR).length >= KEYCLOAK_GROUP_INDEX_COMPANY)
                .map(it -> it.split(KEYCLOAK_GROUP_CHAR_SEPARATOR)[KEYCLOAK_GROUP_INDEX_COMPANY])
                .map(Group::new)
                .collect(Collectors.toSet());
    }

}
