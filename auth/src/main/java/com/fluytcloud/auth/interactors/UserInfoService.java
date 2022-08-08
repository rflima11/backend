package com.fluytcloud.auth.interactors;

import com.fluytcloud.auth.entities.UserInfo;
import com.fluytcloud.auth.entities.UserInfoContext;
import com.fluytcloud.auth.repositories.UserInfoRepository;
import com.fluytcloud.auth.transport.http.exception.AccessDeniedException;
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

    @Inject
    CompanyService companyService;

    private void set(UserInfo userInfo) {
        userInfoRepository.setBySessionId(sessionService.getSessionId(), userInfo);
        UserInfoContext.setCurrentTenant(userInfo);
    }

    public void set(String identifier) {
        var userInfo = companyService.getUserCompanyByIdentifier(identifier)
                .map(UserInfo::new)
                .orElseThrow(AccessDeniedException::new);
        set(userInfo);
    }

    public void delete() {
        userInfoRepository.deleteBySessionId(sessionService.getSessionId());
    }

    public Optional<UserInfo> get() {
        return userInfoRepository.getBySessionId(sessionService.getSessionId());
    }

}
