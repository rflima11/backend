package com.fluytcloud.auth.transport.http.exception;

import com.fluytcloud.rest.exception.RestException;

import javax.ws.rs.core.Response;

public class DuplicatedRecord extends RestException {

    public DuplicatedRecord(String message) {
        super(Response.Status.CONFLICT.getStatusCode(), message);
    }
}
