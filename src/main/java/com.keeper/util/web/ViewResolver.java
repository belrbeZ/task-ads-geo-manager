package com.keeper.util.web;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

/**
 * Default Comment
 */
public class ViewResolver {
    public static final String PAGE_REGISTER = "register";
    public static final String PAGE_LOGIN   = "login";
    public static final String PAGE_LOGOUT  = "logout";
    public static final String PAGE_WELCOME = "welcome";
    public static final String PAGE_INFO    = "info";
    public static final String PAGE_HOME    = "home";
    public static final String PAGE_PROFILE = "profile";
    public static final String PAGE_ERROR   = "error";
    public static final String PAGE_DENIED  = "denied";

    public static final String TEST_PACKAGE = "test/";

    public static final String TEST_PAGE_USER = TEST_PACKAGE + "usertest";
    public static final String TEST_PAGE_ZONE = TEST_PACKAGE + "zonetest";

    public static String redirect(String viewName) {
        return "redirect:/" + viewName;
    }
}
