package com.fluytcloud.api.transport.http;

import com.fluycloud.support.entities.DuplicatedKeyException;
import com.fluycloud.support.entities.EntityNotFoundException;
import com.fluycloud.support.interactors.PersonService;
import com.fluytcloud.api.transport.exception.DuplicatedRecordException;
import com.fluytcloud.api.transport.exception.NoContentException;
import com.fluytcloud.api.transport.exception.NotFoundException;
import com.fluytcloud.api.transport.mapper.PersonMapper;
import com.fluytcloud.api.transport.request.PersonRequest;
import com.fluytcloud.api.transport.response.PersonResponse;
import io.quarkus.security.Authenticated;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/person")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    private static final PersonMapper PERSON_MAPPER = new PersonMapper();
    private static final String PERSON_NOT_FOUND = "Pessoa não encontrada";

    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GET
    @RolesAllowed({"administrator", "manager"})
    public Response findAll(@QueryParam("page") Integer page, @QueryParam("size") Integer size) {
        var pageable = personService.findAll(PageRequest.of(page, size));
        var pagination = new PageImpl<>(
                pageable.getContent()
                        .stream()
                        .map(PERSON_MAPPER::mapResponseList)
                        .toList(),
                pageable.getPageable(),
                pageable.getTotalElements()
        );
        return Response.ok(pagination).build();
    }

    @GET
    @Path("{id}")
    @RolesAllowed({"administrator", "manager"})
    public PersonResponse findById(@PathParam("id") Integer id) {
        return personService.findById(id)
                .map(PERSON_MAPPER::mapResponse)
                .orElseThrow(() -> new NoContentException(PERSON_NOT_FOUND));
    }

    @POST
    @RolesAllowed({"administrator", "manager"})
    public Response create(PersonRequest personRequest) {
        var person = PERSON_MAPPER.map(personRequest);
        try {
            person = personService.create(person);
            return Response.ok(PERSON_MAPPER.mapResponse(person)).build();
        } catch (DuplicatedKeyException exception) {
            throw new DuplicatedRecordException(exception.getMessage());
        }
    }

    @PUT
    @Path("{id}")
    @RolesAllowed({"administrator", "manager"})
    public Response update(@PathParam("id") Integer id, PersonRequest personRequest) {
        var person = PERSON_MAPPER.map(personRequest, id);
        try {
            person = personService.update(id, person);
            return Response.ok(PERSON_MAPPER.mapResponse(person)).build();
        } catch (DuplicatedKeyException exception) {
            throw new DuplicatedRecordException(exception.getMessage());
        } catch (EntityNotFoundException notFoundException) {
            throw new NotFoundException(notFoundException.getMessage());
        }
    }

    @DELETE
    @Path("{id}")
    @RolesAllowed({"administrator", "manager"})
    public Response delete(@PathParam("id") Integer id) {
        try {
            personService.delete(id);
            return Response.noContent().build();
        } catch (EntityNotFoundException notFoundException) {
            throw new NotFoundException(notFoundException.getMessage());
        }
    }

}
