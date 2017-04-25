package com.keeper.util.resolve;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

/**
 * Default Comment
 */
public class ApiResolver {
    public static final String API_PRIVATE  = WebResolver.SECURED + "/api";
    public static final String API_PUBLIC   = "/api";
    public static final String API_VERSION  = "/v1.0";

    public static final String REST_PROFILE = API_PRIVATE + "/profile";
    public static final String REST_TASK    = API_PRIVATE + "/tasks";
    public static final String REST_ZONE    = API_PRIVATE + "/zone";
    public static final String REST_ROUTE   = API_PRIVATE + "/routes";
    public static final String REST_GEOPOINT = API_PRIVATE + "/points";
    public static final String REST_SEARCH_TASK = API_PRIVATE + "/search";

    public static final String TEST_REST_PROFILE = API_PRIVATE + "/test" + "/profile";
    public static final String TEST_REST_ZONE    = API_PRIVATE + "/test" + "/zone";
}
