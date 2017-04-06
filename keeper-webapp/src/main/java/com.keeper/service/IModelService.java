package com.keeper.service;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import java.util.List;

/**
 * Default Comment
 */
public interface IModelService<T> {
    boolean isExists(Long id);

    T add(T model);

    T get(Long id);

    List<T> getAll();

    T update(T model);

    void remove(Long id);
}
