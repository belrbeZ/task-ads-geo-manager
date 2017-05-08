package com.keeper.managers.impl;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.managers.IModelManager;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public class ModelManager<T> implements IModelManager<T> {

    @Override
    public boolean exists(Long id) {
        return false;
    }

    protected T getEmpty() {
        return null;
    }

    protected List<T> getEmptyList() {
        return Collections.emptyList();
    }

    @Override
    public Optional<T> save(T model) {
        return null;
    }

    @Override
    public Optional<T> get(Long id) {
        return null;
    }

    @Override
    public Optional<List<T>> getAll() {
        return null;
    }

    @Override
    public Optional<T> update(T model) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
