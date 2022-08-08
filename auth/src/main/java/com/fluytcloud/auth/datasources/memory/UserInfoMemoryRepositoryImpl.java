package com.fluytcloud.auth.datasources.memory;

import com.fluytcloud.auth.entities.UserInfo;
import com.fluytcloud.auth.repositories.UserInfoRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class UserInfoMemoryRepositoryImpl implements UserInfoRepository {

    private static final Map<String, UserInfo> MAP = new HashMap<>();

    @Override
    public void setBySessionId(String sessionId, UserInfo userInfo) {
        MAP.put(sessionId, userInfo);
    }

    @Override
    public Optional<UserInfo> getBySessionId(String sessionId) {
        return Optional.ofNullable(MAP.get(sessionId));
    }

}