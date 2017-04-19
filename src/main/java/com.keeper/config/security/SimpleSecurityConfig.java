package com.keeper.config.security;

/*
 * Created by @GoodforGod on 19.04.2017.
 */


import com.keeper.util.validation.impl.AuthUserDetailsService;
import com.keeper.util.web.ViewResolver;
import com.keeper.util.web.WebmapResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Default Comment
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SimpleSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final String SECURED    = WebmapResolver.SECURED;
    private final String LOGIN      = WebmapResolver.WEB_LOGIN;
    private final String LOGOUT     = WebmapResolver.WEB_LOGOUT;
    private final String WELCOME    = WebmapResolver.WEB_WELCOME;
    private final String DENIED     = WebmapResolver.WEB_DENIED;

    @Autowired
    public SimpleSecurityConfig(AuthUserDetailsService authUserDetailsService) {
        this.userDetailsService = authUserDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/favicon.ico", "/welcome", "/login", "/register").permitAll()
                    .antMatchers(SECURED + "/**")
                    .access("hasRole('USER')").anyRequest().fullyAuthenticated()
                .and().formLogin()
                    .loginPage(LOGIN).failureForwardUrl(LOGIN + "?error")
                    .usernameParameter("email").passwordParameter("password").defaultSuccessUrl(SECURED + "/home", true)
                .and()
                    .logout().logoutUrl(LOGOUT).deleteCookies("remember-me").logoutSuccessUrl(WELCOME).permitAll()
                .and().csrf().and().rememberMe()
                .and().exceptionHandling().accessDeniedPage(DENIED);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder());
    }

}
