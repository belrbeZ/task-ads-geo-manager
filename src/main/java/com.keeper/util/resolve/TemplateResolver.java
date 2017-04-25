package com.keeper.util.resolve;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

/**
 * Default Comment
 */
public class TemplateResolver {

    public static final String REGISTER = "registration";
    public static final String LOGIN    = "login";
    public static final String LOGOUT   = "logout";

    public static final String ERROR    = "error";
    public static final String DENIED   = "denied";

    public static final String WELCOME  = "welcome";
    public static final String HOME     = "home";
    public static final String PROFILE  = "profile";
    public static final String TASK     = "task";
    public static final String FEED     = "feed";
    public static final String MAPS     = "map";

    public static String redirect(String viewName) {
        return "redirect:/" + viewName;
    }
}
