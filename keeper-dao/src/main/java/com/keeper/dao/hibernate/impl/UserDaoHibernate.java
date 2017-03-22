package com.keeper.dao.hibernate.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 */

import com.keeper.dao.hibernate.UserDao;
import com.keeper.entity.User;

import java.util.List;

/**
 * Default Comment
 */
public class UserDaoHibernate extends GenericDaoHibernate<User, Integer> implements UserDao {

    //<editor-fold desc="UserCRUD">

    public List<User> createUser(List<User> users) {

        return null;
    }

    public List<User> readUser(List<Integer> ids) {

        return null;
    }

    public List<User> updateUser(List<User> users) {

        return null;
    }


    public List<User> deleteUser(List<Integer> ids) {

        return null;
    }
    //</editor-fold>

}
