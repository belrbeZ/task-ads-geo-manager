package com.keeper.config.security;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

/**
 * Default Comment
 */
//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig { //extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private ClientDetailsService clientDetailsService;
//
//    @Bean
//    public ClientDetailsService clientDetailsService() {
//        return new InMemoryClientDetailsService();
//    }
//
//    @Autowired
//    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("pass").roles("ADMIN")
//                .and()
//                .withUser("test").password("cli").roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//            .anonymous().disable()
//            .authorizeRequests()
//            .antMatchers(SecureResolver.PATH_AUTH + SecureResolver.PATH_TOKEN).permitAll();
//    }
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public TokenStore tokenStore() {
//        return new InMemoryTokenStore();
//    }
//
//    @Bean
//    @Autowired
//    public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore){
//        TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
//        handler.setTokenStore(tokenStore);
//        handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
//        handler.setClientDetailsService(clientDetailsService);
//        return handler;
//    }
//
//    @Bean
//    @Autowired
//    public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
//        TokenApprovalStore store = new TokenApprovalStore();
//        store.setTokenStore(tokenStore);
//        return store;
//    }
}
