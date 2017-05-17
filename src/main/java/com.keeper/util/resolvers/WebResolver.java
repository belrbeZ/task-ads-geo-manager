package com.keeper.util.resolvers;

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
    public static final String REGISTER = "/register";
    public static final String WELCOME  = "/welcome";

    public static final String PROFILE  = SECURED + "/profile";
    public static final String LOGOUT   = SECURED + "/logout";
    public static final String MAP      = SECURED + "/map";
    public static final String TASK     = SECURED + "/task";
    public static final String TASK_FORM = TASK + "/form";
    public static final String TASK_SUBS = TASK + "/subscribe";
    public static final String TASK_COMMENT = TASK + "/comment";

    public static final String FEED     = SECURED + "/feed";
    public static final String FEED_FILTER = FEED + "/filter";
    public static final String FEED_SEARCH = FEED + "/search";

    public static final String GEOPOINT = SECURED + "/geopoint";
    public static final String GEOPOINT_CREATE = GEOPOINT + "/create";
    public static final String GEOPOINT_GETLIST = GEOPOINT + "/getlist";
    public static final String GEOPOINT_REMOVE = GEOPOINT + "/remove";
    public static final String GEOPOINT_UPDATE = GEOPOINT + "/update";

}
