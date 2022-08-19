package com.fluytcloud.auth.datasources.keycloak.mapper;

import com.fluytcloud.auth.entities.User;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public class UserRepresentationMapper {

    public UserRepresentation map(User user, List<String> subGroups) {
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setEnabled(true);
        userRepresentation.setUsername(user.getEmail());
        userRepresentation.setFirstName(user.getFirstName());
        if (user.getLastName().isPresent()) {
            userRepresentation.setLastName(user.getLastName().get());
        }

        userRepresentation.setEmail(user.getEmail());
        userRepresentation.setGroups(subGroups);
        return userRepresentation;
    }

}
