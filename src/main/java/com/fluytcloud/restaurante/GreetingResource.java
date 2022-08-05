package com.fluytcloud.restaurante;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/person")
public class GreetingResource {

    private final PersonUseCase personUseCase;

    public GreetingResource(PersonUseCase personUseCase) {
        this.personUseCase = personUseCase;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> findAll() {
        return personUseCase.findAll();
    }
}