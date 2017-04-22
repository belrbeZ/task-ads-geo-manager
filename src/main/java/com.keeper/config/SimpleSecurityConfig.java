package com.keeper.config;

/*
 * Created by @GoodforGod on 19.04.2017.
 */


import com.keeper.model.types.UserType;
import com.keeper.util.resolve.WebResolver;
import com.keeper.util.validation.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Default Comment
 */
@Configuration
@EnableWebSecurity
public class SimpleSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final String ROLE = UserType.USER.toString();

    @Autowired
    public SimpleSecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsService = userDetailsServiceImpl;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", WebResolver.LOGIN, WebResolver.REGISTER).permitAll()
                .antMatchers(WebResolver.SECURED + "/**").hasAuthority(ROLE).anyRequest()
                .authenticated().and().csrf().disable().formLogin()
                .loginPage(WebResolver.LOGIN).failureUrl(WebResolver.LOGIN + "?error=true")
                .defaultSuccessUrl(WebResolver.HOME)
                .usernameParameter("email")
                .passwordParameter("password");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).getUserDetailsService();
//            .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
           .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}
