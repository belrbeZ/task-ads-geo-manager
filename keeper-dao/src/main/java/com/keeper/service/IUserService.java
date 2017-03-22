package com.keeper.service;

/*
 * Created by GoodforGod on 23.03.2017.
 */

import com.keeper.entity.User;

/**
 * Default Comment
 */
public interface IUserService {
    User addUser(User user);

    User getUser(Integer id);
    User getUser(String email, String phone);

    User updateUser(User user);

    User removeUser(Integer id);
    User removeUser(String email, String phone);
}
