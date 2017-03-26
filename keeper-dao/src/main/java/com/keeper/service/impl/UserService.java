package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.dao.hibernate.UserDao;
import com.keeper.dao.hibernate.impl.UserDaoHibernate;
import com.keeper.entity.User;
import com.keeper.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.keeper.util.CollectorResolver.*;

/**
 * Repository to work with User
 */
//@Repository
@Service("userService")
@Transactional
public class UserService implements IUserService {

    private UserDaoHibernate userDao;

    public UserService(UserDao userDao) {
        this.userDao = (UserDaoHibernate)userDao;
    }

    //<editor-fold desc="UserCRUD">

    public User addUser(User user) {
        return getFirstUser(userDao.createUser(makeUserList(user)));
    }

    public User getUser(Long id) {
        return getFirstUser(userDao.readUserById(makeIdList(id)));
    }

    public User getUser(String email, String phone) {
        return (email != null)
                ? getFirstUser(userDao.readUserByEmail(makeStringList(email)))
                : getFirstUser(userDao.readUserByPhone(makeStringList(phone)));
    }

    public User updateUser(User user) {
        return getFirstUser(userDao.updateUser(makeUserList(user)));
    }

    public User removeUser(Long id) {
        return getFirstUser(userDao.deleteUserById(makeIdList(id)));
    }

    public User removeUser(String email, String phone) {
        return (email != null)
                ? getFirstUser(userDao.deleteUserByEmail(makeStringList(email)))
                : getFirstUser(userDao.deleteUserByPhone(makeStringList(phone)));
    }
    //</editor-fold>
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

}
