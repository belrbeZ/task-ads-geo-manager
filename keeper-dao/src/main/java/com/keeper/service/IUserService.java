package com.keeper.service;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.entity.User;

/**
 * Default Comment
 */
public interface IUserService {
    User addUser(User user);

    User getUser(Long id);
    User getUser(String email, String phone);

    User updateUser(User user);

    User removeUser(Long id);
    User removeUser(String email, String phone);
}
