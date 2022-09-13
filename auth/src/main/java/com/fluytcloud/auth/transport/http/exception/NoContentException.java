package com.fluytcloud.auth.transport.http.exception;

import com.fluytcloud.rest.exception.RestException;

public class NoContentException extends RestException {

    public NoContentException(String message) {
        super(204, message);
    }
}
