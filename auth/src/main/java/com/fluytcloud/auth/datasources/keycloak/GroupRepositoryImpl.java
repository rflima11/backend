package com.fluytcloud.auth.datasources.keycloak;

import com.fluytcloud.auth.entities.Group;
import com.fluytcloud.auth.repositories.GroupRepository;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.resource.GroupsResource;
import org.keycloak.representations.idm.GroupRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class GroupRepositoryImpl extends KeycloakConnection implements GroupRepository {

    private final GroupsResource groupsResource;

    public GroupRepositoryImpl() {
        this.groupsResource = getRealmResource().groups();
    }

    @Override
    public boolean create(Group group) {
        GroupRepresentation groupRepresentation = new GroupRepresentation();
        groupRepresentation.setName(group.name());
        groupRepresentation.setPath("/" + group);
        Response response = this.groupsResource.add(groupRepresentation);
        var groupId = CreatedResponseUtil.getCreatedId(response);

        var groupKeycloak = groupsResource.group(groupId);

        group.subGroups()
                .stream()
                .map(subGroup -> {
                    var subGroupRepresentation = new GroupRepresentation();
                    subGroupRepresentation.setName(subGroup.name());
                    subGroupRepresentation.setPath("/" + group.name() + "/" + subGroup);
                    return subGroupRepresentation;
                })
                .forEach(groupKeycloak::subGroup);

        return response.getStatus() == 201;
    }

}
