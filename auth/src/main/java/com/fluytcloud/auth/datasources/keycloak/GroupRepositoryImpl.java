package com.fluytcloud.auth.datasources.keycloak;

import com.fluytcloud.auth.repositories.GroupRepository;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.resource.GroupsResource;
import org.keycloak.representations.idm.GroupRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.Arrays;

@ApplicationScoped
public class GroupRepositoryImpl extends KeycloakConnection implements GroupRepository {

    private final GroupsResource groupsResource;

    public GroupRepositoryImpl() {
        this.groupsResource = getRealmResource().groups();
    }

    @Override
    public boolean create(String group, String... subGroups) {
        GroupRepresentation groupRepresentation = new GroupRepresentation();
        groupRepresentation.setName(group);
        groupRepresentation.setPath("/" + group);
        Response response = this.groupsResource.add(groupRepresentation);
        var groupId = CreatedResponseUtil.getCreatedId(response);

        var groupKeycloak = groupsResource.group(groupId);

        Arrays.stream(subGroups)
                .map(subGroup -> {
                    var subGroupRepresentation = new GroupRepresentation();
                    subGroupRepresentation.setName(subGroup);
                    subGroupRepresentation.setPath("/" + group + "/" + subGroup);
                    return subGroupRepresentation;
                })
                .forEach(groupKeycloak::subGroup);

        return response.getStatus() == 201;

    }

}
