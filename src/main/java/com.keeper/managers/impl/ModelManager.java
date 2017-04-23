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
    public boolean isExists(Long id) {
        return false;
    }

    @Override
    public T getEmpty() {
        return null;
    }

    @Override
    public List<T> getEmptyList() {
        return Collections.emptyList();
    }

    @Override
    public Optional<T> add(T model) {
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
