package com.fluytcloud.product.interactors;

import com.fluytcloud.product.entities.Unit;
import com.fluytcloud.product.repositories.UnitRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UnitService {

    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public Page<Unit> findAll(Pageable pageable) {
        return unitRepository.findAll(pageable);
    }

    public List<Unit> search(String name) {
        if (StringUtils.isBlank(name)) {
            return unitRepository.findAll();
        }
        return unitRepository.search(name);
    }

    public Optional<Unit> findById(Integer id) {
        return unitRepository.findById(id);
    }

}
