package com.fluytcloud.api.transport.http;

import com.fluycloud.support.entities.DuplicatedKeyException;
import com.fluycloud.support.entities.EntityNotFoundException;
import com.fluytcloud.api.transport.exception.DuplicatedRecordException;
import com.fluytcloud.api.transport.exception.NoContentException;
import com.fluytcloud.api.transport.exception.NotFoundException;
import com.fluytcloud.api.transport.mapper.CommentsMapper;
import com.fluytcloud.api.transport.request.CommentsRequest;
import com.fluytcloud.api.transport.response.CommentsResponse;
import com.fluytcloud.product.interactors.CommentsService;
import io.quarkus.security.Authenticated;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/comments")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentsResource {

    private static final String ADDITIONAL_NOT_FOUND = "Observação não encontrada";

    private final CommentsService commentsService;

    public CommentsResource(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GET
    @RolesAllowed({"administrator", "manager"})
    public Response findAll(@QueryParam("page") Integer page, @QueryParam("size") Integer size) {
        var pageable = commentsService.findAll(PageRequest.of(page, size));
        var pagination = new PageImpl<>(
                pageable.getContent()
                        .stream()
                        .map(CommentsMapper::map)
                        .toList(),
                pageable.getPageable(),
                pageable.getTotalElements()
        );
        return Response.ok(pagination).build();
    }

    @GET
    @Path("{id}")
    @RolesAllowed({"administrator", "manager"})
    public CommentsResponse findById(@PathParam("id") Integer id) {
        return commentsService.findById(id)
                .map(CommentsMapper::map)
                .orElseThrow(() -> new NoContentException(ADDITIONAL_NOT_FOUND));
    }

    @POST
    @RolesAllowed({"administrator", "manager"})
    public Response create(CommentsRequest commentsRequest) {
        var comments = CommentsMapper.map(commentsRequest);
        try {
            comments = commentsService.create(comments);
            return Response.ok(CommentsMapper.map(comments)).build();
        } catch (DuplicatedKeyException exception) {
            throw new DuplicatedRecordException(exception.getMessage());
        }
    }

    @PUT
    @Path("{id}")
    @RolesAllowed({"administrator", "manager"})
    public Response update(@PathParam("id") Integer id, CommentsRequest commentsRequest) {
        var comments = CommentsMapper.map(id, commentsRequest);
        try {
            comments = commentsService.update(id, comments);
            return Response.ok(CommentsMapper.map(comments)).build();
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
            commentsService.delete(id);
            return Response.noContent().build();
        } catch (EntityNotFoundException notFoundException) {
            throw new NotFoundException(notFoundException.getMessage());
        }
    }

}