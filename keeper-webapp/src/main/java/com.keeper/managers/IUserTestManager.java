package com.keeper.managers;

/*
 * Created by Alexandr Vasiliev on 30.03.2017.
 */

import com.keeper.entity.dto.UserTestDTO;

/**
 * Default Comment
 */
public interface IUserTestManager extends IModelManager<UserTestDTO> {
    boolean isExists(String email, String phone);

    UserTestDTO get(String email, String phone);

    void remove(String email, String phone);
}
