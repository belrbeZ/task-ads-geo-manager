package com.keeper.managers.impl;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.managers.IModelManager;

import java.util.List;

/**
 * Default Comment
 */
public class ModelManager<T> implements IModelManager<T> {

    @Override
    public boolean isExists(Long id) {
        return false;
    }

    @Override
    public T add(T model) {
        return null;
    }

    @Override
    public T get(Long id) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public T update(T model) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
