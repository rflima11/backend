package com.fluytcloud.admin.transport.http;

import com.fluytcloud.admin.interactors.CustomerPersistUseCase;
import com.fluytcloud.admin.interactors.CustomerService;
import com.fluytcloud.admin.transport.mapper.CustomerMapper;
import com.fluytcloud.admin.transport.request.CustomerRequest;
import com.fluytcloud.admin.transport.response.CustomerListResponse;
import com.fluytcloud.admin.transport.response.CustomerResponse;
import io.quarkus.security.Authenticated;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/api/admin/customer")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private static final CustomerMapper CUSTOMER_MAPPER = new CustomerMapper();
    private final CustomerService customerService;
    private final CustomerPersistUseCase customerPersistUseCase;

    public CustomerResource(CustomerService customerService, CustomerPersistUseCase customerPersistUseCase) {
        this.customerService = customerService;
        this.customerPersistUseCase = customerPersistUseCase;
    }

    @GET
    @RolesAllowed("administrator")
    public Page<CustomerListResponse> findAll(@QueryParam("page") Integer page, @QueryParam("size") Integer size) {
        var pageable = customerService.findAll(PageRequest.of(page, size));
        return new PageImpl<>(
                pageable.getContent()
                        .stream()
                        .map(CUSTOMER_MAPPER::mapResponseList)
                        .toList(),
                pageable.getPageable(),
                pageable.getTotalElements()
        );
    }

    @GET
    @Path("{id}")
    @RolesAllowed("administrator")
    public Optional<CustomerResponse> findById(@PathParam("id") Integer id) {
        return customerService.findById(id)
                .map(CUSTOMER_MAPPER::mapResponse);
    }

    @POST
    @RolesAllowed("administrator")
    public void create(CustomerRequest customerRequest) {
        var customer = CUSTOMER_MAPPER.map(customerRequest);
        customerPersistUseCase.create(customer);
    }

}
