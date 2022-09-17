package com.fluycloud.support.entities;

public class DuplicatedCnpj extends RuntimeException {
    private static final String MESSAGE = "CNPJ já cadastrado";

    public DuplicatedCnpj() {
        super(MESSAGE);
    }
}
