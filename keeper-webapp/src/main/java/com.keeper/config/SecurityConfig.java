package com.keeper.config;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.util.ViewNameResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security Config File
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String ROLE_AUTH  = ViewNameResolver.SECURE_ROLE_AUTH;
    private final String ROLE_ADMIN = ViewNameResolver.SECURE_ROLE_ADMIN;

    private final String PATH_AUTH  = ViewNameResolver.SECURE_PATH_AUTH;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // DEFAULT VALUES IN ERROR DB CASE
        String admin_login = "masTer";
        String admin_pass = "6c6d6437af";

        auth.inMemoryAuthentication()
                .withUser(admin_login)
                .password(admin_pass)
                .roles(ROLE_AUTH);
    }

    // Permit all to login, and auth to admin*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/favicon.ico").permitAll()
                .antMatchers("/" + PATH_AUTH + "/**", "/")
                .access("hasRole(" + ROLE_AUTH + ")")
                .and().formLogin().loginPage("/oauth")
                .usernameParameter("uid").passwordParameter("password")
                .defaultSuccessUrl("/" + PATH_AUTH + "/welcome", true)
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/denied");
    }
}
