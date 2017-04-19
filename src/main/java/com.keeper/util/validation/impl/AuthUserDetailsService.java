package com.keeper.util.validation.impl;

/*
 * Created by @GoodforGod on 19.04.2017.
 */

import com.keeper.model.dao.User;
import com.keeper.service.impl.UserRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Default Comment
 */
@Service
public class AuthUserDetailsService implements UserDetailsService {

    private final UserRepoService userService;

    @Autowired
    public AuthUserDetailsService(UserRepoService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional(readOnly = true)
    public AuthUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
        return new AuthUser(user);
    }
}
