package com.keeper.util.validation.impl;

/*
 * Created by @GoodforGod on 19.04.2017.
 */


import com.keeper.model.dao.User;
import com.keeper.model.types.UserType;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Default Comment
 */
public class AuthUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public AuthUser(User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getType().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public UserType getRole() {
        return user.getType();
    }
}
