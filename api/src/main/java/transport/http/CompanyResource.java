package transport.http;

import com.fluycloud.support.interactors.CompanyService;
import com.fluytcloud.auth.transport.http.exception.NoContentException;
import io.quarkus.security.Authenticated;
import transport.mapper.CompanyMapper;
import transport.response.CompanyListResponse;
import transport.response.CompanyResponse;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
}
