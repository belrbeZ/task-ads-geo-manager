package com.keeper.config.security.oauth;

/*
 * Created by GoodforGod on 19.03.2017.
 */

/**
 * Spring Security Config File
 */
//@Configuration
//@EnableResourceServer
public class ResourceSecurityConfig { //extends ResourceServerConfigurerAdapter{
//
//    private final String ROLE_USER  = "hasRole('" + SecureResolver.ROLE_USER + "')" ;
//    private final String ROLE_ADMIN = SecureResolver.ROLE_ADMIN;
//
//    private final String PATH_AUTH  = SecureResolver.PATH_AUTH + "/**";
//    private final String PATH_ADMIN = SecureResolver.PATH_ADMIN + "/**";
//
//    private final String ResourceId = WebmapResolver.LOGIN;
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resource) {
//        resource.resourceId(ResourceId).stateless(false);
//    }
//
//    // Permit all to login, and auth to admin*
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.anonymous().disable().requestMatchers().antMatchers(PATH_AUTH)
//                .and().authorizeRequests()
//                .antMatchers(PATH_AUTH).access(ROLE_USER)
//                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
//    }
}
