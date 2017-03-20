package com.keeper.dao;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Default Comment
 */
public class UserDaoHibernate {

    public static final List<User> emptyUserList = new ArrayList<User>();

    //<editor-fold desc="UserCRUD">

    public List<User> getUser(List<Integer> id) {

        return emptyUserList;
    }

    public List<User> updateUser(List<User> user) {

        return emptyUserList;
    }

    public List<User> createUser(List<User> user) {

        return emptyUserList;
    }

    public List<User> removeUser(List<Integer> id) {

        return emptyUserList;
    }
    //</editor-fold>

}
