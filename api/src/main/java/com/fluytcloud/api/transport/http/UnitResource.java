package com.fluytcloud.api.transport.http;

import com.fluytcloud.api.transport.exception.NoContentException;
import com.fluytcloud.api.transport.mapper.UnitMapper;
import com.fluytcloud.api.transport.response.UnitResponse;
import com.fluytcloud.product.interactors.UnitService;
import io.quarkus.security.Authenticated;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/public/v1/unit")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UnitResource {

    private final UnitService unitService;

    private static final String UNIT_NOT_FOUND = "Unidade não encontrada";

    public UnitResource(UnitService unitService) {
        this.unitService = unitService;
    }

    @GET
    public Response findAll(@QueryParam("page") Integer page, @QueryParam("size") Integer size) {
        var pageable = unitService.findAll(PageRequest.of(page, size));
        var pagination = new PageImpl<>(
                pageable.getContent()
                        .stream()
                        .map(UnitMapper::map)
                        .toList(),
                pageable.getPageable(),
                pageable.getTotalElements()
        );
        return Response.ok(pagination).build();
    }

    @GET
    @Path("complete")
    public List<UnitResponse> search(@QueryParam("search") String search) {
        return unitService
                .search(search)
                .stream()
                .map(UnitMapper::map)
                .toList();
    }

    @GET
    @Path("{id}")
    public UnitResponse findById(@PathParam("id") Integer id) {
        return unitService.findById(id)
                .map(UnitMapper::map)
                .orElseThrow(() -> new NoContentException(UNIT_NOT_FOUND));
    }
}
