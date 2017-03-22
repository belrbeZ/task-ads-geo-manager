package com.keeper.DaoFactory;

import com.keeper.Hibernate.HibernateUtil;
import com.keeper.dao.GenericHibernateDAO;
import com.keeper.DaoHibernate.LocationDaoHibernate;
import com.keeper.DaoHibernate.TaskDaoHibernate;
import com.keeper.DaoHibernate.UserDaoHibernate;
import com.keeper.dao.LocationDAO;
import com.keeper.dao.TaskDAO;
import com.keeper.dao.UserDAO;
import org.hibernate.Session;

/**
 * Created by AlexVasil on 22.03.2017.
 */
public class HibernateDAOFactory extends DAOFactory {

    public LocationDAO getLocationDAO() {
        return (LocationDAO)instantiateDAO(LocationDaoHibernate.class);
    }

    public TaskDAO getTaskDAO() {
        return (TaskDAO)instantiateDAO(TaskDaoHibernate.class);
    }

    public UserDAO getUserDAO() {
        return (UserDAO)instantiateDAO(UserDaoHibernate.class);
    }

    private GenericHibernateDAO instantiateDAO(Class daoClass) {
        try {
            GenericHibernateDAO dao = (GenericHibernateDAO)daoClass.newInstance();
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