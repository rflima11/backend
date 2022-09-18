package com.fluytcloud.api.transport.http;

import com.fluycloud.support.entities.DuplicatedCnpjException;
import com.fluycloud.support.interactors.CompanyService;
import com.fluytcloud.api.transport.response.CompanyListResponse;
import com.fluytcloud.api.transport.response.CompanyResponse;
import com.fluytcloud.api.transport.exception.DuplicatedRecordException;
import com.fluytcloud.api.transport.exception.NoContentException;
import io.quarkus.security.Authenticated;
import com.fluytcloud.api.transport.mapper.CompanyMapper;
import com.fluytcloud.api.transport.request.CompanyRequest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/company")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompanyResource {
    private static final CompanyMapper COMPANY_MAPPER = new CompanyMapper();
    private static final String COMPANY_NOT_FOUND = "Filial não encontrada";

    private final CompanyService companyService;

    public CompanyResource(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GET
    @RolesAllowed({"administrator", "manager"})
    public List<CompanyListResponse> findAll() {
        return companyService.findAll()
                .stream()
                .map(COMPANY_MAPPER::mapResponseList)
                .toList();
    }

    @GET
    @Path("{id}")
    @RolesAllowed({"administrator", "manager"})
    public CompanyResponse findById(@PathParam("id") Integer id) {
        return companyService.findById(id)
                .map(COMPANY_MAPPER::mapResponse)
                .orElseThrow(() -> new NoContentException(COMPANY_NOT_FOUND));
    }

    @POST
    @RolesAllowed({"administrator", "manager"})
    public Response create(CompanyRequest companyRequest) {
        var company = COMPANY_MAPPER.map(companyRequest);
        try {
            company = companyService.create(company);
            return Response.ok(COMPANY_MAPPER.mapResponse(company)).build();
        } catch (DuplicatedCnpjException exception) {
            throw new DuplicatedRecordException(exception.getMessage());
        }
    }
}