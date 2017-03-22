package com.keeper.dao.hibernate.impl;

import com.keeper.dao.hibernate.GenericDao;
import com.keeper.entity.IModel;
import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Lopast' on 22.03.2017.
 */
public abstract class GenericDaoHibernate<MODEL extends IModel<ID>, ID extends Serializable>
        implements GenericDao<MODEL, ID> {

    private Class<MODEL> persistentClass;
    private Session session;

    public GenericDaoHibernate() {
        try {
            this.persistentClass = (Class<MODEL>) ((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];
        } catch (ClassCastException ex){
            System.err.println("(GenericDaoHibernate() -> this.persistentClass) Can't cast! "+ex);
        }
    }

    @SuppressWarnings("unchecked")
    public void setSession(Session s) {
        this.session = s;
    }

    protected Session getSession() {
//        if (session == null)
//            throw new IllegalStateException("Session has not been set on DAO before usage");

//        if the client didn't provide a Session when the DAO was constructed
        if (session == null)
            session = HibernateUtil.getSessionFactory().getCurrentSession();

        return session;
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
    public List<MODEL> findAll() {
        return findByCriteria();
    }

    @SuppressWarnings("unchecked")
    public List<MODEL> findByExample(MODEL exampleInstance, String[] excludeProperty) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        Example example =  Example.create(exampleInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
        }
        crit.add(example);
        return crit.list();
    }

    @SuppressWarnings("unchecked")
    public List<MODEL> findByExample(MODEL exampleInstance) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        Example example =  Example.create(exampleInstance);
        crit.add(example);
        return crit.list();
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

    /**
     * Use this inside subclasses as a convenience method.
     */
    @SuppressWarnings("unchecked")
    protected List<MODEL> findByCriteria(Criterion... criterion) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
    }

}