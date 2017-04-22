package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.model.dao.User;
import com.keeper.repo.UserRepository;
import com.keeper.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public boolean isExistsByPhone(String phone) {
        return (phone != null && !phone.isEmpty()) && repository.existsByPhone(phone);
    }

    @Override
    public boolean isExistsByEmail(String email) {
        return (email != null && !email.isEmpty()) && repository.existsByEmail(email);
    }

    @Override
    public boolean isUserLoginDataValid(String email, String password) {
        return (getByEmail(email).orElse(getEmpty()).getPassword().equals(password));
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return (email != null && !email.isEmpty()) ? repository.findOneByEmail(email) : null;
    }

    @Override
    public Optional<User> getByPhone(String phone) {
        return (phone != null && !phone.isEmpty()) ? repository.findOneByPhone(phone) : null;
    }

    @Override
    public User removeByEmail(String email) {
        return (email != null && !email.isEmpty())
                ? repository.removeByEmail(email).orElse(getEmpty()) : getEmpty();
    }

    @Override
    public User removeByPhone(String phone) {
        return (phone != null && !phone.isEmpty())
                ? repository.removeByPhone(phone).orElse(getEmpty()) : getEmpty();
    }
}
