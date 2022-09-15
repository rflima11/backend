package com.fluytcloud.auth.transport.http.resource;

import com.fluytcloud.auth.interactors.UserInfoService;
import com.fluytcloud.auth.transport.http.mapper.UserInfoMapper;
import com.fluytcloud.auth.transport.http.response.UserInfoResponse;
import com.fluytcloud.core.entities.UserInfoContext;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/auth")
public class AuthResource {

    @Inject
    UserInfoService userInfoService;

    private static final UserInfoMapper USER_INFO_MAPPER = new UserInfoMapper();

    @GET
    @Path("/full-authentication")
    public boolean fullAuthentication() {
        return UserInfoContext.getCurrentUserInfo() != null;
    }

    @POST
    @Path("/full-authentication")
    public void post(String identifier) {
        userInfoService.set(identifier);
    }

    @POST
    @Path("/logout")
    public void logout() {
        userInfoService.delete();
    }

    @GET
    public UserInfoResponse get() {
        return USER_INFO_MAPPER.map(UserInfoContext.getCurrentUserInfo());
    }

}
