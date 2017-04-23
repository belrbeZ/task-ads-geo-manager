package com.keeper.test.managers.impl;

import com.keeper.test.model.dto.UserTestDTO;
import com.keeper.test.managers.IUserTestManager;
import com.keeper.test.service.impl.UserTestRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 05.04.2017.
 *
 * @author Alexandr Vasiliev
 */
@Service
public class UserTestManager implements IUserTestManager {

    @Autowired
    private UserTestRepoService userTestRepoService;

    @Override
    public boolean isExists(String email, String phone) {
        return false;
    }

    @Override
    public UserTestDTO get(String email, String phone) {
        return null;
    }

    @Override
    public void remove(String email, String phone) {

    }
}
