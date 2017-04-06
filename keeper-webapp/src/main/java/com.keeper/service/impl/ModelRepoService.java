package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.repo.UserTestRepository;
import com.keeper.service.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Basic model with ID as a LONG type PARAMETER!
 */
@Service
public class ModelRepoService<T> implements IModelService<T> {

    private final JpaRepository<T, Long> repository;

    @Autowired
    public ModelRepoService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    public boolean isExists(Long id) {
        return repository.exists(id);
    }

    @Override
    public T add(T model) {
        return repository.save(model);
    }

    @Override
    public T get(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T update(T model) {
        return repository.save(model);
    }

    @Override
    public void remove(Long id) {
        repository.delete(id);
    }
}
