package com.keeper.service;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.keeper.entity.dao.UserTest;

/**
 * Default Comment
 */
public interface IUserTestService extends IModelService<UserTest> {
    boolean isExists(String email, String phone);

    UserTest get(String email, String phone);

    void remove(String email, String phone);
}
