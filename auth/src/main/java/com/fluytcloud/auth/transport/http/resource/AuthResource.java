package com.fluytcloud.auth.transport.http.resource;

import com.fluytcloud.auth.entities.UserInfoContext;
import com.fluytcloud.auth.interactors.UserInfoService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/auth")
public class AuthResource {

    @Inject
    UserInfoService userInfoService;

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

}
