package com.keeper.dao.hibernate.impl;

import com.keeper.dao.hibernate.GenericDao;
import com.keeper.entity.IModel;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

public abstract class GenericDaoHibernate<MODEL extends IModel<ID>, ID extends Serializable>
        implements GenericDao<MODEL, ID> {

    private Class<MODEL> persistentClass;

    public GenericDaoHibernate() {
        try {
            this.persistentClass = (Class<MODEL>) ((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];
        } catch (ClassCastException ex){
            System.err.println("(GenericDaoHibernate() -> this.persistentClass) Can't cast! "+ex);
        }
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public Class<MODEL> getPersistentClass() {
        return persistentClass;
    }

    @SuppressWarnings("unchecked")
    public MODEL findById(ID id, boolean lock) {
        MODEL entity;
        if (lock)
            entity = getSession().load(getPersistentClass(), id, LockOptions.UPGRADE);
        else
            entity = getSession().load(getPersistentClass(), id);

        return entity;
    }

    @SuppressWarnings("unchecked")
    public MODEL makePersistent(MODEL entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    public void makeTransient(MODEL entity) {
        getSession().delete(entity);
    }

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }

}