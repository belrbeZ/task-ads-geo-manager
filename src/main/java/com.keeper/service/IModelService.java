package com.keeper.service;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public interface IModelService<T> {

    T getEmpty();

    List<T> getEmptyList();

    boolean isExists(Long id);

    Optional<T> add(T model);

    Optional<T> get(Long id);

    Optional<List<T>> getAll();

    Optional<T> update(T model);

    void remove(Long id);
}
