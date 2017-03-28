package com.keeper.config;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.util.WebappResolver;

import com.keeper.util.SecureResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

/**
 * Spring Security Config File
 */
@Configuration
@EnableResourceServer
public class ResourceSecurityConfig extends ResourceServerConfigurerAdapter{

    private final String ROLE_CLIENT  = "hasRole('" + SecureResolver.ROLE_CLIENT + "')" ;
    private final String ROLE_ADMIN = SecureResolver.ROLE_ADMIN;

    private final String PATH_AUTH  = SecureResolver.PATH_AUTH + "/**";
    private final String PATH_ADMIN = SecureResolver.PATH_ADMIN + "/**";

    private final String ResourceId = WebappResolver.WEB_OAUTH;

    @Override
    public void configure(ResourceServerSecurityConfigurer resource) {
        resource.resourceId(ResourceId).stateless(false);
    }

    // Permit all to login, and auth to admin*
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.anonymous().disable().requestMatchers().antMatchers(PATH_AUTH)
                .and().authorizeRequests()
                .antMatchers(PATH_AUTH).access(ROLE_CLIENT)
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
