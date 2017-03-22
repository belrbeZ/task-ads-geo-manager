package com.keeper.dao.hibernate.factory;

import com.keeper.dao.hibernate.LocationDao;
import com.keeper.dao.hibernate.TaskDao;
import com.keeper.dao.hibernate.UserDao;

/**
 * Created by AlexVasil on 22.03.2017.
 */
public abstract class FactoryDao {

    /**
     * Creates a standalone FactoryDao that returns unmanaged DAO
     * beans for use in any environment Hibernate has been configured
     * for. Uses HibernateUtil/SessionFactory and Hibernate context
     * propagation (CurrentSessionContext), thread-bound or transaction-bound,
     * and transaction scoped.
     */
    public static final Class HIBERNATE = FactoryDaoHibernate.class;//?

    /**
     * Factory method for instantiation of concrete factories.
     */
    public static FactoryDao instance(Class factory) {
        try {
            return (FactoryDao)factory.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create FactoryDao: " + factory);
        }
    }

    // Add your DAO interfaces here
    public abstract LocationDao getLocationDAO();
    public abstract TaskDao getTaskDAO();
    public abstract UserDao getUserDAO();

}