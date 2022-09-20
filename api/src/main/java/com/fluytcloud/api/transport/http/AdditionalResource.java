package com.fluytcloud.api.transport.http;

import com.fluycloud.support.entities.DuplicatedKeyException;
import com.fluycloud.support.entities.EntityNotFoundException;
import com.fluytcloud.api.transport.exception.DuplicatedRecordException;
import com.fluytcloud.api.transport.exception.NoContentException;
import com.fluytcloud.api.transport.exception.NotFoundException;
import com.fluytcloud.api.transport.mapper.AdditionalMapper;
import com.fluytcloud.api.transport.request.AdditionalRequest;
import com.fluytcloud.api.transport.response.AdditionalResponse;
import com.fluytcloud.product.interactors.AdditionalService;
import io.quarkus.security.Authenticated;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/additional")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdditionalResource {

    private static final String ADDITIONAL_NOT_FOUND = "Adicional não encontrado";

    private final AdditionalService additionalService;

    public AdditionalResource(AdditionalService additionalService) {
        this.additionalService = additionalService;
    }

    @GET
    @RolesAllowed({"administrator", "manager"})
    public Response findAll(@QueryParam("page") Integer page, @QueryParam("size") Integer size) {
        var pageable = additionalService.findAll(PageRequest.of(page, size));
        var pagination = new PageImpl<>(
                pageable.getContent()
                        .stream()
                        .map(AdditionalMapper::map)
                        .toList(),
                pageable.getPageable(),
                pageable.getTotalElements()
        );
        return Response.ok(pagination).build();
    }

    @GET
    @Path("{id}")
    @RolesAllowed({"administrator", "manager"})
    public AdditionalResponse findById(@PathParam("id") Integer id) {
        return additionalService.findById(id)
                .map(AdditionalMapper::map)
                .orElseThrow(() -> new NoContentException(ADDITIONAL_NOT_FOUND));
    }

    @POST
    @RolesAllowed({"administrator", "manager"})
    public Response create(AdditionalRequest additionalRequest) {
        var additional = AdditionalMapper.map(additionalRequest);
        try {
            additional = additionalService.create(additional);
            return Response.ok(AdditionalMapper.map(additional)).build();
        } catch (DuplicatedKeyException exception) {
            throw new DuplicatedRecordException(exception.getMessage());
        }
    }

    @PUT
    @Path("{id}")
    @RolesAllowed({"administrator", "manager"})
    public Response update(@PathParam("id") Integer id, AdditionalRequest additionalRequest) {
        var additional = AdditionalMapper.map(id, additionalRequest);
        try {
            additional = additionalService.update(id, additional);
            return Response.ok(AdditionalMapper.map(additional)).build();
        } catch (DuplicatedKeyException exception) {
            throw new DuplicatedRecordException(exception.getMessage());
        } catch (EntityNotFoundException notFoundException) {
            throw new com.fluytcloud.api.transport.exception.NotFoundException(notFoundException.getMessage());
        }
    }

    @DELETE
    @Path("{id}")
    @RolesAllowed({"administrator", "manager"})
    public Response delete(@PathParam("id") Integer id) {
        try {
            additionalService.delete(id);
            return Response.noContent().build();
        } catch (EntityNotFoundException notFoundException) {
            throw new NotFoundException(notFoundException.getMessage());
        }
    }

}