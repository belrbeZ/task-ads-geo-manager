package com.keeper.service;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.keeper.model.dao.User;

import java.util.Optional;

/**
 * Default Comment
 */
public interface IUserService extends IModelService<User> {
    boolean isExistsByPhone(String phone);
    boolean isExistsByEmail(String email);

    boolean isUserLoginDataValid(String email, String password);

    Optional<User> getByEmail(String email);
    Optional<User> getByPhone(String phone);

    User removeByEmail(String email);
    User removeByPhone(String phone);
}
