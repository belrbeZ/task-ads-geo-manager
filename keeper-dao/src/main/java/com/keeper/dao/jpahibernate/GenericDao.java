package com.keeper.dao.jpahibernate;

import com.keeper.entity.IModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 * Updated by AlexVasil on 28.03.2017.
 *
 */
public interface GenericDao<T extends IModel<PK>, PK extends Serializable> {

    /**
     * Returns a item with its id
     *
     * @param id
     *      Public Key of item.
     * @return T
     *      Object of choosed type.
     */
    T getById(PK id);

    List<T> findAll();

    T create(T t);

    T update(T t);

    void delete(T t);

}