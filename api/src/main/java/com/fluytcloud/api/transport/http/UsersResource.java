package com.fluytcloud.api.transport.http;

import com.fluytcloud.api.transport.mapper.UserMapper;
import com.fluytcloud.api.transport.request.UserRequest;
import com.fluytcloud.auth.interactors.UserService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    private static final UserMapper USER_MAPPER = new UserMapper();

    private final UserService userService;

    public UsersResource(UserService userService) {
        this.userService = userService;
    }

    @POST
    public void create(UserRequest userRequest) {
        var user = USER_MAPPER.map(userRequest);
        userService.create(user);
    }

}