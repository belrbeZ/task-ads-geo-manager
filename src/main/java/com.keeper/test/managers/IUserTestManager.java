package com.keeper.test.managers;

/*
 * Created by Alexandr Vasiliev on 30.03.2017.
 */

import com.keeper.test.model.dto.UserTestDTO;
import com.keeper.managers.IModelManager;

/**
 * Default Comment
 */
public interface IUserTestManager {
    boolean isExists(String email, String phone);

    UserTestDTO get(String email, String phone);

    void remove(String email, String phone);
}
