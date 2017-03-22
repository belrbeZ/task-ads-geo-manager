package com.keeper.repo;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 */

import com.keeper.DaoHibernate.UserDaoHibernate;
import com.keeper.dao.UserDAO;
import com.keeper.entity.User;

import static com.keeper.util.CollectorResolver.makeIdList;
import static com.keeper.util.CollectorResolver.makeUserList;

import static com.keeper.util.CollectorResolver.getFirstUser;

/**
 * Repository to work with User
 */
public class UserRepository {

    private UserDaoHibernate userDao;

    public UserRepository(UserDAO userDao) {
        this.userDao = (UserDaoHibernate)userDao;
    }

    public UserDaoHibernate getUserDao() {
        return userDao;
    }

    //<editor-fold desc="UserCRUD">

    public User addUser(User user) {
        return getFirstUser(userDao.createUser(makeUserList(user)));
    }

    public User getUser(Integer id) {
        return getFirstUser(userDao.readUser(makeIdList(id)));
    }

    public User updateUser(User user) {
        return getFirstUser(userDao.updateUser(makeUserList(user)));
    }

    public User removeUser(Integer id) {
        return getFirstUser(userDao.deleteUser(makeIdList(id)));
    }
    //</editor-fold>

}
