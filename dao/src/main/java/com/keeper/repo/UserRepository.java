package com.keeper.repo;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.entity.User;

/**
 * Default Comment
 */
public class UserRepository {

    public User getUser(Integer id) {

        return new User();
    }

    public User patchUser(Integer id) {

        return new User();
    }

}
