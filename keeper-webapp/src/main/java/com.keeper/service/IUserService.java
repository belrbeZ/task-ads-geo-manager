package com.keeper.service;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.keeper.entity.dao.User;

/**
 * Default Comment
 */
public interface IUserService extends IModelService<User> {
    boolean isExists(String email, String phone);

    User get(String email, String phone);

    User remove(String email, String phone);
}
