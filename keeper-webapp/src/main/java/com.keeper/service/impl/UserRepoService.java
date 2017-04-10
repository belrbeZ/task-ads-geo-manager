package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.entity.dao.User;
import com.keeper.repo.UserRepository;
import com.keeper.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Default Comment
 */
@Service
public class UserRepoService extends ModelRepoService<User> implements IUserService {

    private final UserRepository repository;

    @Autowired
    public UserRepoService(UserRepository repository) {
        this.repository = repository;
        this.primeRepository = repository;
    }

    @Override
    public boolean isExists(String email, String phone) {
        return (email != null && !email.isEmpty())
                ? repository.existsByEmail(email)
                : repository.existsByPhone(phone);
    }

    @Override
    public User get(String email, String phone) {
        return (email != null && !email.isEmpty())
                ? repository.findOneByEmail(email)
                : repository.findOneByPhone(phone);
    }

    @Override
    public User remove(String email, String phone) {
        return (email != null && !email.isEmpty())
                ? repository.removeByEmail(email)
                : repository.removeByPhone(phone);
    }
}
