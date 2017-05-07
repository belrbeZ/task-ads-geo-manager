package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.service.IModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Basic model with ID as a LONG type PARAMETER!
 */
@Service
public class ModelRepoService<T> implements IModelService<T> {

    protected final Logger LOGGER = LoggerFactory.getLogger(ModelRepoService.class);

    protected JpaRepository<T, Long> primeRepository;

    @Override
    public T getEmpty() {
        return null;
    }

    public List<T> getEmptyList() {
        return Collections.emptyList();
    }

    @Override
    public boolean isExists(Long id) {
        return (id != null) && primeRepository.exists(id);
    }

    // Ask what to return, exception or empty/null in case of NULL
    @Transactional
    @Override
    public Optional<T> add(T model) {
        return  Optional.of(primeRepository.save(model));
    }

    @Override
    public Optional<T> get(Long id) {
        return Optional.of(primeRepository.findOne(id));
    }

    @Override
    public Optional<List<T>> getAll() {
        return Optional.of(primeRepository.findAll());
    }

    // Ask what to return, exception or empty/null in case of NULL
    @Transactional
    @Override
    public Optional<T> update(T model) {
        return Optional.of(primeRepository.save(model));
    }

    @Transactional
    @Override
    public void remove(Long id) {
        primeRepository.delete(id);
    }
}
