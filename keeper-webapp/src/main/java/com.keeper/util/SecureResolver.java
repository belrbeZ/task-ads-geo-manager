package com.keeper.util;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

/**
 * Default Comment
 */
public class SecureResolver {
    public static final String TRUSTED_CLIENT_ID    = "trusted-client";

    public static final String ROLE_ADMIN           = "ROLE_ADMIN";
    public static final String ROLE_CLIENT          = "ROLE_CLIENT";
    public static final String ROLE_TRUSTED_CLIENT  = "ROLE_TRUSTED_CLIENT";

    // In Seconds
    public static final Integer ACCESS_TOKEN_PERIOD  = 240;
    public static final Integer REFRESH_TOKEN_PERIOD = 3600;

    public static final String PATH_AUTH    = "/auth";
    public static final String PATH_TOKEN   = "/token";
    public static final String PATH_ADMIN   = "/admin";
}
