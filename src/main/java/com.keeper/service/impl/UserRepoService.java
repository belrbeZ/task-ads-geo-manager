package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.model.dao.User;
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
    public User getEmpty() {
        return User.EMPTY;
    }

    @Override
    public boolean isExists(String email, String phone) {
        return (email != null && !email.isEmpty())
                ? repository.existsByEmail(email)
                : (phone != null && !phone.isEmpty()) && repository.existsByPhone(phone);
    }

    @Override
    public boolean isUserLoginDataValid(String email, String phone, String password) {
        return (get(email, phone).getPassword().equals(password));
    }

    @Override
    public User get(String email, String phone) {
        return (email != null && !email.isEmpty())
                ? repository.findOneByEmail(email).orElse(getEmpty())
                : (phone != null && !phone.isEmpty()) ? repository.findOneByPhone(phone).orElse(getEmpty()) : getEmpty();
    }

    @Override
    public User remove(String email, String phone) {
        return (email != null && !email.isEmpty())
                ? repository.removeByEmail(email).orElse(getEmpty())
                : (phone != null && !phone.isEmpty()) ? repository.removeByPhone(phone).orElse(getEmpty()) : getEmpty();
    }
}
