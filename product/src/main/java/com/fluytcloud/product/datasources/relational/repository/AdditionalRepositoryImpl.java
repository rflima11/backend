package com.fluytcloud.product.datasources.relational.repository;

import com.fluycloud.support.core.CrudMapper;
import com.fluycloud.support.core.CrudRepositoryImpl;
import com.fluytcloud.product.datasources.relational.mapper.AdditionalModelMapper;
import com.fluytcloud.product.datasources.relational.model.AdditionalModel;
import com.fluytcloud.product.entities.Additional;
import com.fluytcloud.product.repositories.AdditionalRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class AdditionalRepositoryImpl extends CrudRepositoryImpl<Additional, AdditionalModel, Integer> implements AdditionalRepository {

    private final AdditionalJpaRepository additionalJpaRepository;

    public AdditionalRepositoryImpl(AdditionalJpaRepository additionalJpaRepository) {
        this.additionalJpaRepository = additionalJpaRepository;
    }

    @Override
    protected JpaRepository<AdditionalModel, Integer> getJpaRepository() {
        return additionalJpaRepository;
    }

    @Override
    protected CrudMapper<Additional, AdditionalModel> getMapper() {
        return new AdditionalModelMapper();
    }

    @Override
    public List<Additional> search(String search) {
        var list = StringUtils.isBlank(search)
                ? additionalJpaRepository.findAll(pageable).getContent()
                : additionalJpaRepository.findByNameContainingIgnoreCase(search, pageable);
        return list.stream()
                .map(it -> getMapper().mapToEntity(it))
                .toList();
    }

}
