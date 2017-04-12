package com.keeper.managers.test;

import com.keeper.entity.dto.UserTestDTO;
import com.keeper.service.test.UserTestRepoService;
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
    public UserTestDTO getEmpty() {
        return null;
    }

    @Override
    public boolean isExists(Long id) {
        return false;
    }

    @Override
    public UserTestDTO add(UserTestDTO model) {
        return null;
    }

    @Override
    public UserTestDTO get(Long id) {
        return null;
    }

    @Override
    public boolean isExists(String email, String phone) {
        return false;
    }

    @Override
    public List<UserTestDTO> getAll() {
        return null;
    }

    @Override
    public UserTestDTO update(UserTestDTO model) {
        return null;
    }

    @Override
    public UserTestDTO get(String email, String phone) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void remove(String email, String phone) {

    }
}
