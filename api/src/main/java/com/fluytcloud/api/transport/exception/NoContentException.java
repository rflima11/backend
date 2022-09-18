package com.fluytcloud.api.transport.exception;

import com.fluytcloud.rest.exception.RestException;

import javax.ws.rs.core.Response;

public class NoContentException extends RestException {

    public NoContentException(String message) {
        super(Response.Status.NO_CONTENT.getStatusCode(), message);
    }
}
