package com.fluycloud.support.entities;

public class DuplicatedCnpjException extends RuntimeException {
    private static final String MESSAGE = "CNPJ já cadastrado";

    public DuplicatedCnpjException() {
        super(MESSAGE);
    }

}
