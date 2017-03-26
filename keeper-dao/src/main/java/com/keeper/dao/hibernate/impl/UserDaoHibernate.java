package com.keeper.dao.hibernate.impl;

import com.keeper.dao.hibernate.UserDao;
import com.keeper.entity.User;

import java.util.List;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

public class UserDaoHibernate extends GenericDaoHibernate<User, Long> implements UserDao {


    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        // Note, this query is also possible with Spring Data JPAs "Derived Query" technique, which magically implements
        // interface methods based on the name.
        return getSession().createQuery("select u from Users u").list();
    }

    //<editor-fold desc="UserCRUD">

    public List<User> createUser(List<User> users) {

        return null;
    }

    public List<User> readUserById(List<Long> ids) {

        return null;
    }

    public List<User> readUserByEmail(List<String> emails) {

        return null;
    }

    public List<User> readUserByPhone(List<String> phone) {

        return null;
    }

    public List<User> updateUser(List<User> users) {

        return null;
    }

    public List<User> deleteUserById(List<Long> ids) {

        return null;
    }

    public List<User> deleteUserByEmail(List<String> emails) {

        return null;
    }

    public List<User> deleteUserByPhone(List<String> phones) {

        return null;
    }
    //</editor-fold>

}
