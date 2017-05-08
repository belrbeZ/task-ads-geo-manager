package com.keeper.util.resolve;

/*
 * Created by GoodforGod on 26.03.2017.
 */

/**
 * Stores all paths for Controllers and Rest End Points
 */
public class WebResolver {
    public static final String SECURED  = "/secure";
    private static final String OAUTH    = "/oauth";
    private static final String TOKEN    = "/token";

    public static final String ERROR    = "/error";
    public static final String DENIED   = "/denied";
    public static final String LOGIN    = "/login";
    public static final String LOGOUT   = "/logout";
    public static final String WELCOME  = "/welcome";
    public static final String REGISTER = "/registration";
    public static final String HOME     = SECURED + "/home";
    public static final String PROFILE  = SECURED + "/profile";
    public static final String TASK     = SECURED + "/task";
    public static final String TASK_CREATE = TASK + "/create";
    public static final String FEED     = SECURED + "/feed";
    public static final String MAP      = SECURED + "/map";
    public static final String GEOPOINT = SECURED + "/geopoint";
    public static final String GEOPOINT_CREATE = GEOPOINT + "/create";
    public static final String GEOPOINT_GETLIST = GEOPOINT + "/getlist";
    public static final String GEOPOINT_REMOVE = GEOPOINT + "/remove";
    public static final String GEOPOINT_UPDATE = GEOPOINT + "/update";

}
