package com.keeper.DaoFactory;

import com.keeper.dao.LocationDAO;
import com.keeper.dao.TaskDAO;
import com.keeper.dao.UserDAO;

/**
 * Created by AlexVasil on 22.03.2017.
 */
public abstract class DAOFactory {

    /**
     * Creates a standalone DAOFactory that returns unmanaged DAO
     * beans for use in any environment Hibernate has been configured
     * for. Uses HibernateUtil/SessionFactory and Hibernate context
     * propagation (CurrentSessionContext), thread-bound or transaction-bound,
     * and transaction scoped.
     */
    public static final Class HIBERNATE = com.keeper.DaoFactory.HibernateDAOFactory.class;//?

    /**
     * Factory method for instantiation of concrete factories.
     */
    public static DAOFactory instance(Class factory) {
        try {
            return (DAOFactory)factory.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create DAOFactory: " + factory);
        }
    }

    // Add your DAO interfaces here
    public abstract LocationDAO getLocationDAO();
    public abstract TaskDAO getTaskDAO();
    public abstract UserDAO getUserDAO();

}