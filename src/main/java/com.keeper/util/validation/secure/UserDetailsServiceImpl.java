package com.keeper.util.validation.secure;

/*
 * Created by @GoodforGod on 19.04.2017.
 */

import com.keeper.model.dao.User;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.resolvers.SecureResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Default Comment
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService service;

    @Autowired
    public UserDetailsServiceImpl(UserService service) {
        this.service = service;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = service.getByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No user present with email: " + email));

        return new UserCredentials(user, SecureResolver.ROLE_USER);
    }
}
