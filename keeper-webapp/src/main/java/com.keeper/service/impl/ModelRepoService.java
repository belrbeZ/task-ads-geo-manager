package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.service.IModelService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Basic model with ID as a LONG type PARAMETER!
 */
@Service
public class ModelRepoService<T> implements IModelService<T> {

    protected JpaRepository<T, Long> primeRepository;

    @Override
    public boolean isExists(Long id) {
        return primeRepository.exists(id);
    }

    @Override
    public T add(T model) {
        return primeRepository.save(model);
    }

    @Override
    public T get(Long id) {
        return primeRepository.findOne(id);
    }

    @Override
    public List<T> getAll() {
        return primeRepository.findAll();
    }

    @Override
    public T update(T model) {
        return primeRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        primeRepository.delete(id);
    }
}
