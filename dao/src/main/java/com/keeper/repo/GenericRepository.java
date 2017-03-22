package com.keeper.repo;

import com.keeper.DaoFactory.DAOFactory;
import com.keeper.dao.LocationDAO;
import com.keeper.dao.UserDAO;
import com.keeper.entity.Location;
import com.keeper.entity.User;

/**
 * Created by AlexVasil on 22.03.2017.
 */
public class GenericRepository {

//     EJB3 CMT:
//     @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void execute() {

        // JTA:
        // UserTransaction utx = jndiContext.lookup("UserTransaction");
        // JTA:
        // utx.begin();

        // Plain JDBC:
        // HibernateUtil.getCurrentSession().beginTransaction();

        DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);

        LocationRepository locationRepository = new LocationRepository(factory.getLocationDAO());
        UserRepository userRepository = new UserRepository(factory.getUserDAO());
        TaskRepository taskRepository = new TaskRepository(factory.getTaskDAO());



        LocationDAO locationDAO = factory.getLocationDAO();
        UserDAO userDAO = factory.getUserDAO();

        Location location = locationDAO.findById(1, true);

        User user = userDAO.findById(1, false);

        // JTA:
        // utx.commit(); // Don't forget exception handling

        // Plain JDBC:
        // HibernateUtil.getCurrentSession().getTransaction().commit(); // Don't forget exception handling

    }

}
