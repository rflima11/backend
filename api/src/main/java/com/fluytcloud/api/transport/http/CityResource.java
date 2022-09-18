package com.fluytcloud.api.transport.http;

import com.fluycloud.support.interactors.CityService;
import com.fluytcloud.api.transport.response.CityResponse;
import com.fluytcloud.auth.transport.http.exception.NoContentException;
import io.quarkus.security.Authenticated;
import com.fluytcloud.api.transport.mapper.CityMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/public/v1/city")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CityResource {

    private final CityService cityService;

    private static final String CITY_NOT_FOUND = "Cidade não encontrada";

    public CityResource(CityService cityService) {
        this.cityService = cityService;
    }

    @GET
    public List<CityResponse> search(@QueryParam("name") String name) {
        return cityService
                .search(name)
                .stream()
                .map(CityMapper::map)
                .toList();
    }

    @GET
    @Path("{id}")
    public CityResponse findById(@PathParam("id") Integer id) {
        return cityService.findById(id)
                .map(CityMapper::map)
                .orElseThrow(() -> new NoContentException(CITY_NOT_FOUND));
    }
}
