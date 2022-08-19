package com.fluytcloud.api.transport.mapper;

import com.fluytcloud.api.transport.request.UserRequest;
import com.fluytcloud.auth.entities.User;
import com.fluytcloud.auth.entities.UserInfoContext;

public class UserMapper {

    public User map(UserRequest userRequest) {
        return new User(
                userRequest.email(),
                userRequest.name(),
                UserInfoContext.getCurrentUserInfo().company().identifier(),
                userRequest.branches()
        );
    }

}
