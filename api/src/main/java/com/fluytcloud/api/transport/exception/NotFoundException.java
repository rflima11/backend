package com.fluytcloud.api.transport.exception;

import com.fluytcloud.rest.exception.RestException;

import javax.ws.rs.core.Response;

public class NotFoundException extends RestException {

    public NotFoundException(String message) {
        super(Response.Status.NOT_FOUND.getStatusCode(), message);
    }

}
