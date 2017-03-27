package com.keeper.service;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.entity.User;

import java.util.List;

/**
 * Default Comment
 */
public interface IUserService {
    User addUser(User user);

    User getUser(Long id);
    User getUser(User user);
    User getUser(String email, String phone);

    List<User> getAllUsers();

    User updateUser(User user);

    void removeUser(Long id);
    User removeUser(User user);
    void removeUser(String email, String phone);
}
