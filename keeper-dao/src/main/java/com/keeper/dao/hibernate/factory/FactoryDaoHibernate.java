package com.keeper.dao.hibernate.factory;

import com.keeper.dao.hibernate.impl.*;
import com.keeper.dao.hibernate.impl.GenericDaoHibernate;
import com.keeper.dao.hibernate.LocationDao;
import com.keeper.dao.hibernate.TaskDao;
import com.keeper.dao.hibernate.UserDao;
import org.hibernate.Session;

/**
 * Created by AlexVasil on 22.03.2017.
 */
public class FactoryDaoHibernate extends FactoryDao {

    public LocationDao getLocationDAO() {
        return (LocationDao)instantiateDAO(LocationDaoHibernate.class);
    }

    public TaskDao getTaskDAO() {
        return (TaskDao)instantiateDAO(TaskDaoHibernate.class);
    }

    public UserDao getUserDAO() {
        return (UserDao)instantiateDAO(UserDaoHibernate.class);
    }

    private GenericDaoHibernate instantiateDAO(Class daoClass) {
        try {
            GenericDaoHibernate dao = (GenericDaoHibernate)daoClass.newInstance();
            dao.setSession(getCurrentSession());
            return dao;
        } catch (Exception ex) {
            throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);
        }
    }

    // You could override this if you don't want HibernateUtil for lookup
    protected Session getCurrentSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

}