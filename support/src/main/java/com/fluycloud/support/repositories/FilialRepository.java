package com.fluycloud.support.repositories;

import com.fluycloud.support.entities.Filial;

import java.util.List;
import java.util.Optional;

public interface FilialRepository {

    List<Filial> findAll();

    Optional<Filial> findById(Integer id);

    Filial persist(Filial filial);

}
