package com.fluytcloud.api.transport.exception;

import com.fluytcloud.rest.exception.RestException;

import javax.ws.rs.core.Response;

public class DuplicatedRecordException extends RestException {

    public DuplicatedRecordException(String message) {
        super(Response.Status.CONFLICT.getStatusCode(), message);
    }

}
