package com.fluytcloud.auth.interactors;

import com.fluytcloud.auth.repositories.UserInfoRepository;
import com.fluytcloud.auth.transport.http.exception.AccessDeniedException;
import com.fluytcloud.core.entities.UserInfo;
import com.fluytcloud.core.entities.UserInfoContext;
import com.fluytcloud.security.interactors.SessionService;
import io.quarkus.oidc.runtime.OidcJwtCallerPrincipal;
import io.quarkus.security.identity.SecurityIdentity;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class UserInfoService {

    private final SessionService sessionService;

    private final SecurityIdentity securityIdentity;

    private final UserInfoRepository userInfoRepository;

    private final CompanyService companyService;

    public UserInfoService(
            SessionService sessionService,
            SecurityIdentity securityIdentity,
            UserInfoRepository userInfoRepository,
            CompanyService companyService) {
        this.sessionService = sessionService;
        this.securityIdentity = securityIdentity;
        this.userInfoRepository = userInfoRepository;
        this.companyService = companyService;
    }

    private void set(UserInfo userInfo) {
        userInfoRepository.setBySessionId(sessionService.getSessionId(), userInfo);
        UserInfoContext.setCurrentTenant(userInfo);
    }

    public void set(String schemaName) {
        var name = ((OidcJwtCallerPrincipal) securityIdentity.getPrincipal()).getClaim("name").toString();
        var username = securityIdentity.getPrincipal().getName();

        var userInfo = companyService.getUserCompanyBySchemaName(schemaName)
                .map(it -> new UserInfo(name, username, it))
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
