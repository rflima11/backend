package com.fluytcloud.product.interactors;

import com.fluycloud.support.core.CrudRepository;
import com.fluycloud.support.core.CrudServiceImpl;
import com.fluytcloud.product.entities.Additional;
import com.fluytcloud.product.repositories.AdditionalRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AdditionalService extends CrudServiceImpl<Additional, Integer> {

    private final AdditionalRepository additionalRepository;

    public AdditionalService(AdditionalRepository additionalRepository) {
        this.additionalRepository = additionalRepository;
    }

    @Override
    protected CrudRepository<Additional, Integer> getRepository() {
        return additionalRepository;
    }

}
