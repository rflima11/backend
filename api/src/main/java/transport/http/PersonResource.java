package transport.http;

import com.fluycloud.support.entities.DuplicatedCnpjException;
import com.fluycloud.support.interactors.PersonService;
import com.fluytcloud.auth.transport.http.exception.DuplicatedRecord;
import com.fluytcloud.auth.transport.http.exception.NoContentException;
import io.quarkus.security.Authenticated;
import transport.mapper.PersonMapper;
import transport.request.PersonRequest;
import transport.response.PersonListResponse;
import transport.response.PersonResponse;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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
    public List<PersonListResponse> findAll() {
        return personService.findAll()
                .stream()
                .map(PERSON_MAPPER::mapResponseList)
                .toList();
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
        var company = PERSON_MAPPER.map(personRequest);
        try {
            company = personService.create(company);
            return Response.ok(PERSON_MAPPER.mapResponse(company)).build();
        } catch (DuplicatedCnpjException exception) {
            throw new DuplicatedRecord(exception.getMessage());
        }
    }

}
