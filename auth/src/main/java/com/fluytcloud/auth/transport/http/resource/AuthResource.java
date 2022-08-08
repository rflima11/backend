package com.fluytcloud.auth.transport.http.resource;

import com.fluytcloud.auth.entities.UserInfoContext;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/auth")
public class AuthResource {

    @GET
    @Path("/full-authentication")
    public boolean fullAuthentication() {
        return UserInfoContext.getCurrentUserInfo() != null;
    }

}
