package com.fluytcloud.auth.repositories;

import com.fluytcloud.auth.entities.UserInfo;

import java.util.Optional;

public interface UserInfoRepository {

    void setBySessionId(String sessionId, UserInfo userInfo);

    Optional<UserInfo> getBySessionId(String sessionId);

}
