package com.keeper.service.testing;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.keeper.entity.dao.UserTest;

/**
 * Default Comment
 */
public interface IUserTestService {
    boolean isExists(String email, String phone);

    UserTest get(String email, String phone);

    UserTest remove(String email, String phone);
}
