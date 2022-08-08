package com.fluytcloud.auth.interactors;

import com.fluytcloud.auth.entities.UserInfo;
import com.fluytcloud.auth.entities.UserInfoContext;
import com.fluytcloud.auth.repositories.UserInfoRepository;
import com.fluytcloud.security.interactors.SessionService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class UserInfoService {

    @Inject
    SessionService sessionService;

    @Inject
    UserInfoRepository userInfoRepository;

    public void set(UserInfo userInfo) {
        userInfoRepository.setBySessionId(sessionService.getSessionId(), userInfo);
        UserInfoContext.setCurrentTenant(userInfo);
    }

    public Optional<UserInfo> get() {
        return userInfoRepository.getBySessionId(sessionService.getSessionId());
    }

}
