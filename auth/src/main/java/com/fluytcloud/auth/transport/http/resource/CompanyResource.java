package com.fluytcloud.auth.transport.http.resource;

import com.fluytcloud.auth.entities.UserInfo;
import com.fluytcloud.auth.interactors.CompanyService;
import com.fluytcloud.auth.interactors.UserInfoService;
import com.fluytcloud.auth.transport.http.response.CompanyResponse;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/companies")
public class CompanyResource {

    @Inject
    CompanyService companyService;

    @Inject
    UserInfoService userInfoService;

    @GET
    public List<CompanyResponse> get() {
        return companyService.getUserCompanies()
                .stream()
                .map(it -> new CompanyResponse(it.name(), it.identifier()))
                .toList();
    }

    @POST
    public void post(String identifier) {
        var userInfo = companyService.getByIdentifier(identifier)
                .map(it -> new UserInfo(it.id()));
        userInfo.ifPresent(info -> userInfoService.set(info));
    }

}
