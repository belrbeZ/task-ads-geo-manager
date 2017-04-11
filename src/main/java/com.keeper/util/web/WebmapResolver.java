package com.keeper.util.web;

/*
 * Created by GoodforGod on 26.03.2017.
 */

/**
 * Stores all paths for Controllers and Rest End Points
 */
public class WebmapResolver {
    public static final String REDIRECT     = ":redirect";

    public static final String SECURED  = "/secure";
    public static final String TESTING  = "/test";
    public static final String OAUTH    = "/oauth";
    public static final String TOKEN    = "/token";

    public static final String TEST_PATH    = "/test";
    public static final String TEST_USER    = SECURED + TEST_PATH + "/user";
    public static final String TEST_ZONE    = SECURED + TEST_PATH + "/zone";

    public static final String WEB_ERROR    = "/error";
    public static final String WEB_DENIED   = "/denied";
    public static final String WEB_HOME     = SECURED + "/home";
    public static final String WEB_LOGIN    = "/login";
    public static final String WEB_LOGOUT   = "/logout";
    public static final String WEB_PROFILE  = SECURED + "/profile";
    public static final String WEB_WELCOME  = "/welcome";
    public static final String WEB_REGISTER = "/register";
}
