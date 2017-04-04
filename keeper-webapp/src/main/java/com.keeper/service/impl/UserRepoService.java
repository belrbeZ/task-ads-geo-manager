package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.repo.UserRepository;
import com.keeper.model.dao.User;
import com.keeper.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Repository to work with User
 */
@Service
public class UserRepoService implements IUserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public User getUser(String email, String phone) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void removeUser(Long id) {

    }

    @Override
    public void removeUser(String email, String phone) {

    }
}
