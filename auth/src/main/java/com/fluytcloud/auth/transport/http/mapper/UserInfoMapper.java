package com.fluytcloud.auth.transport.http.mapper;

import com.fluytcloud.auth.entities.UserInfo;
import com.fluytcloud.auth.transport.http.response.UserInfoResponse;

public class UserInfoMapper {

    public UserInfoResponse map(UserInfo userInfo) {
        return new UserInfoResponse(
                userInfo.name(),
                userInfo.username(),
                userInfo.company().name()
        );
    }

}
