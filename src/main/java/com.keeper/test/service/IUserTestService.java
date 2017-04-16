package com.keeper.test.service;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.keeper.test.model.dao.UserTest;

/**
 * Default Comment
 */
public interface IUserTestService {
    boolean isExists(String email, String phone);

    UserTest get(String email, String phone);

    UserTest remove(String email, String phone);
}
