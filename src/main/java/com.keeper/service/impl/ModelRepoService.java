package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.service.IModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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
    @Override
    public T add(T model) {
        return  (model != null) ? primeRepository.save(model) : getEmpty();
    }

    @Override
    public T get(Long id) {
        return (id != null) ? primeRepository.findOne(id) : getEmpty();
    }

    @Override
    public List<T> getAll() {
        return primeRepository.findAll();
    }

    // Ask what to return, exception or empty/null in case of NULL
    @Override
    public T update(T model) {
        return (model != null) ? primeRepository.save(model) : getEmpty();
    }

    @Override
    public void remove(Long id) {
        if(id != null)
            primeRepository.delete(id);
    }
}
