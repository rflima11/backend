package com.fluytcloud.api.transport.http;

import com.fluytcloud.api.transport.mapper.UserMapper;
import com.fluytcloud.api.transport.request.UserRequest;
import com.fluytcloud.auth.interactors.UserService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/api/users")
public class UsersResource {

    private static final UserMapper USER_MAPPER = new UserMapper();

    @Inject
    UserService userService;

    @POST
    public void create(UserRequest userRequest) {
        var user = USER_MAPPER.map(userRequest);
        userService.create(user);
    }

}