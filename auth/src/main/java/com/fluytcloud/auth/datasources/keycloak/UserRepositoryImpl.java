package com.fluytcloud.auth.datasources.keycloak;

import com.fluytcloud.auth.datasources.keycloak.mapper.UserRepresentationMapper;
import com.fluytcloud.auth.entities.User;
import com.fluytcloud.auth.repositories.UserRepository;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.*;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

    private static final UserRepresentationMapper MAPPER  = new UserRepresentationMapper();
    private final GroupsResource groupsResource;
    private final UsersResource usersRessource;

    public UserRepositoryImpl() {
        var keycloak = KeycloakBuilder.builder()
                .serverUrl("https://auth.fluytcloud.com")
                .realm("restaurante")
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId("app-backend")
                .clientSecret("qz4cQj1YqC9a5ghnGFrXHdjeRWsJceUe")
                .build();

        RealmResource realmResource = keycloak.realm("restaurante");
        groupsResource = realmResource.groups();
        usersRessource = realmResource.users();
    }

    public void create(User user) {
        var subGroups = getSubGroupsPath(user.getGroup(), user.getSubGroups());

        UserRepresentation userRepresentation = MAPPER.map(user, subGroups);

        Response response = usersRessource.create(userRepresentation);
        if (response.getStatus() == 201) {
            CredentialRepresentation passwordCred = new CredentialRepresentation();
            passwordCred.setTemporary(false);
            passwordCred.setType(CredentialRepresentation.PASSWORD);
            passwordCred.setValue("123");

            String userId = CreatedResponseUtil.getCreatedId(response);
            UserResource userResource = usersRessource.get(userId);
            userResource.resetPassword(passwordCred);
        } else if (response.getStatus() == 409) {
            throw new RuntimeException("Usuário já existe");
        }
    }

    private GroupResource getGroupResource(String group) {
        var groups = groupsResource.groups(
                group,
                0,
                1
        );

        if (groups.isEmpty()) {
            throw new RuntimeException("Grupo não encontrado");
        }

        var firstGroup = groups.get(0);
        return groupsResource.group(firstGroup.getId());
    }

    private List<String> getSubGroupsPath(String group, List<String> subGroups) {
        var subGroupsPath = getGroupResource(group)
                .toRepresentation()
                .getSubGroups()
                .stream()
                .filter(it -> subGroups.contains(it.getName()))
                .map(GroupRepresentation::getPath)
                .toList();

        if (subGroupsPath.isEmpty()) {
            throw new RuntimeException("Subgrupo não encontrado");
        }

        return subGroupsPath;
    }

}