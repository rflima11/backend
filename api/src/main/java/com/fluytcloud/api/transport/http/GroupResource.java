package com.fluytcloud.api.transport.http;

import com.fluycloud.support.entities.DuplicatedKeyException;
import com.fluycloud.support.entities.EntityNotFoundException;
import com.fluytcloud.api.transport.exception.DuplicatedRecordException;
import com.fluytcloud.api.transport.exception.NoContentException;
import com.fluytcloud.api.transport.exception.NotFoundException;
import com.fluytcloud.api.transport.mapper.GroupMapper;
import com.fluytcloud.api.transport.request.GroupRequest;
import com.fluytcloud.api.transport.response.GroupResponse;
import com.fluytcloud.product.interactors.GroupService;
import io.quarkus.security.Authenticated;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/group")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GroupResource {
    private static final String GROUP_NOT_FOUND = "Grupo não encontrado";

    private final GroupService groupService;

    public GroupResource(GroupService groupService) {
        this.groupService = groupService;
    }

    @GET
    @RolesAllowed({"administrator", "manager"})
    public Response findAll(@QueryParam("page") Integer page, @QueryParam("size") Integer size) {
        var pageable = groupService.findAll(PageRequest.of(page, size));
        var pagination = new PageImpl<>(
                pageable.getContent()
                        .stream()
                        .map(GroupMapper::map)
                        .toList(),
                pageable.getPageable(),
                pageable.getTotalElements()
        );
        return Response.ok(pagination).build();
    }

    @GET
    @Path("{id}")
    @RolesAllowed({"administrator", "manager"})
    public GroupResponse findById(@PathParam("id") Integer id) {
        return groupService.findById(id)
                .map(GroupMapper::map)
                .orElseThrow(() -> new NoContentException(GROUP_NOT_FOUND));
    }

    @POST
    @RolesAllowed({"administrator", "manager"})
    public Response create(GroupRequest groupRequest) {
        var group = GroupMapper.map(groupRequest);
        try {
            group = groupService.create(group);
            return Response.ok(GroupMapper.map(group)).build();
        } catch (DuplicatedKeyException exception) {
            throw new DuplicatedRecordException(exception.getMessage());
        }
    }

    @PUT
    @Path("{id}")
    @RolesAllowed({"administrator", "manager"})
    public Response update(@PathParam("id") Integer id, GroupRequest groupRequest) {
        var group = GroupMapper.map(id, groupRequest);
        try {
            group = groupService.update(group);
            return Response.ok(GroupMapper.map(group)).build();
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
            groupService.delete(id);
            return Response.noContent().build();
        } catch (EntityNotFoundException notFoundException) {
            throw new NotFoundException(notFoundException.getMessage());
        }
    }

}

