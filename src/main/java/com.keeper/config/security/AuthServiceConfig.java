package com.keeper.config.security;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

/**
 * Default Comment
 */
//@Configuration
//@EnableAuthorizationServer
public class AuthServiceConfig {//  extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    private TokenStore tokenStore;
//
//    @Autowired
//    private UserApprovalHandler userApprovalHandler;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    private final String TRUSTED_CLIENT_ID = SecureResolver.TRUSTED_CLIENT_ID;
//    private final String REALM ="MY_OAUTH_REALM";
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient(TRUSTED_CLIENT_ID)
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//                .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//                .scopes("read", "write", "trust")
//                .secret("secret")
//                .accessTokenValiditySeconds(SecureResolver.ACCESS_TOKEN_PERIOD)
//                .refreshTokenValiditySeconds(SecureResolver.REFRESH_TOKEN_PERIOD);
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.tokenStore(tokenStore)
//                .userApprovalHandler(userApprovalHandler)
//                .authenticationManager(authenticationManager);
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//        oauthServer.realm(REALM + "/client");
//    }
}
