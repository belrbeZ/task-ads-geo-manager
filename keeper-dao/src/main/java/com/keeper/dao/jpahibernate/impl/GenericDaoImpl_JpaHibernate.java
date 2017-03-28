package com.keeper.dao.jpahibernate.impl;

import com.keeper.dao.jpahibernate.GenericDao;
import com.keeper.entity.IModel;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 * Updated by AlexVasil on 2.03.2017.
 *
 */

public abstract class GenericDaoImpl_JpaHibernate<T extends IModel<PK>, PK extends Serializable>
        implements GenericDao<T, PK> {

//    @Autowired
    protected Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public GenericDaoImpl_JpaHibernate() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass
                .getActualTypeArguments()[0];
    }

    @Override
    public T create(T t) {
        this.entityManager.persist(t);
        return t;
    }

    @Override
    public T getById(PK id) {
        return this.entityManager.find(entityClass, id);
    }

    @Override
    public T update(T t) {
        return this.entityManager.merge(t);
    }

    @Override
    public void delete(T t) {
        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
    }

}