package com.keeper.service.modelbased.impl;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.service.modelbased.IModelService;
import com.keeper.util.Validator;
import com.keeper.util.resolve.ErrorMessageResolver;
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
public class ModelService<T> implements IModelService<T> {

    protected final Logger LOGGER = LoggerFactory.getLogger(ModelService.class);

    protected JpaRepository<T, Long> primeRepository;

    protected T getEmpty() {
        return null;
    }

    protected List<T> getEmptyList() {
        return Collections.emptyList();
    }

    @Override
    public boolean exists(Long id) {
        return (Validator.isIdValid(id)) && primeRepository.exists(id);
    }

    protected boolean invalidId(Long id, String msg) {
        if(!Validator.isIdValid(id)) {
            LOGGER.warn(msg);
            return true;
        }
        return false;
    }

    protected boolean invalidModel(T model, String msg) {
        if(model == null) {
            LOGGER.warn(msg);
            return true;
        }
        return false;
    }

    @Override
    public Optional<T> get(Long id) {
        if(invalidId(id, ErrorMessageResolver.GET_NULLABLE_ID))
            return Optional.empty();

        return Optional.of(primeRepository.findOne(id));
    }

    @Override
    public Optional<List<T>> getAll() {
        return Optional.of(primeRepository.findAll());
    }

    // Ask what to return, exception or empty/null in case of NULL
    @Transactional
    @Override
    public Optional<T> save(T model) {
        if(invalidModel(model, ErrorMessageResolver.CREATE_MODEL_NULLABLE))
            return Optional.empty();

        return Optional.of(primeRepository.save(model));
    }

    // Ask what to return, exception or empty/null in case of NULL
    @Transactional
    @Override
    public Optional<T> update(T model) {
        if(invalidModel(model, ErrorMessageResolver.UPDATE_MODEL_NULLABLE))
            return Optional.empty();

        return Optional.of(primeRepository.save(model));
    }

    @Transactional
    @Override
    public void remove(Long id) {
        if(invalidId(id, ErrorMessageResolver.REMOVE_NULLABLE_ID))
            throw new NullPointerException("NULLABLE id request DELETE");

        primeRepository.delete(id);

        System.out.println("Removed? "+id.toString());

    }
}
