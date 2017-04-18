package com.keeper.util.web;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

/**
 * Default Comment
 */
public class ApiResolver {
    public static final String API          = WebmapResolver.SECURED + "/api";
    public static final String API_VERSION  = "/v1.0";

    public static final String PRODUCES_CHARSET = "charset=UTF-8;";

    public static final String REST_PROFILE = API + "/profile";
    public static final String REST_TASK    = API + "/tasks";
    public static final String REST_ZONE    = API + "/zone";
    public static final String REST_ROUTE   = API + "/routes";
    public static final String REST_GEOPOINT = API + "/points";

    public static final String TEST_REST_PROFILE = API + "/test" + "/profile";
    public static final String TEST_REST_ZONE    = API + "/test" + "/zone";
}
