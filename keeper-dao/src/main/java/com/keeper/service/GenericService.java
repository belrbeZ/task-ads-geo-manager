package com.keeper.service;

import com.keeper.dao.hibernate.factory.FactoryDao;
import com.keeper.dao.hibernate.LocationDao;
import com.keeper.dao.hibernate.UserDao;
import com.keeper.entity.Location;
import com.keeper.entity.User;

/**
 * Created by AlexVasil on 22.03.2017.
 */
public class GenericService {

//     EJB3 CMT:
//     @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void execute() {

        // JTA:
        // UserTransaction utx = jndiContext.lookup("UserTransaction");
        // JTA:
        // utx.begin();

        // Plain JDBC:
        // HibernateUtil.getCurrentSession().beginTransaction();

        FactoryDao factory = FactoryDao.instance(FactoryDao.HIBERNATE);

        LocationService locationService = new LocationService(factory.getLocationDAO());
        UserService userService = new UserService(factory.getUserDAO());
        TaskService taskRepository = new TaskService(factory.getTaskDAO());



        LocationDao locationDao = factory.getLocationDAO();
        UserDao userDao = factory.getUserDAO();

        Location location = locationDao.findById(1, true);

        User user = userDao.findById(1, false);

        // JTA:
        // utx.commit(); // Don't forget exception handling

        // Plain JDBC:
        // HibernateUtil.getCurrentSession().getTransaction().commit(); // Don't forget exception handling

    }

}
