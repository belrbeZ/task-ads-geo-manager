package com.keeper.dao.hibernate;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AlexVasil on 22.03.2017.
 */
public interface GenericDao<T, PK extends Serializable> {

    T findById(PK id, boolean lock);

    List<T> findAll();

    List<T> findByExample(T exampleInstance);

    T makePersistent(T entity);

    void makeTransient(T entity);
}