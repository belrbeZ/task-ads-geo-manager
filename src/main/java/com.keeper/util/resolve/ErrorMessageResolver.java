package com.keeper.util.resolve;

/*
 * Created by @GoodforGod on 08.05.2017.
 */

/**
 * Default Comment
 */
public class ErrorMessageResolver {

    public static final String NOT_FOUND = "model NOT EXIST ";
    public static final String NULLABLE_ID = "NULLABLE ID ";
    public static final String NULLABLE_MODEL = "model is NULLABLE ";

    public static final String UPDATE_NOT_FOUND = "During UPDATE, " + NOT_FOUND;
    public static final String GET_NULLABLE_ID = "During GET, " + NULLABLE_ID;
    public static final String UPDATE_NULLABLE_ID   = "During UPDATE, " + NULLABLE_ID;
    public static final String CREATE_NULLABLE_ID   = "During CREATE, " + NULLABLE_ID;
    public static final String REMOVE_NULLABLE_ID = "During REMOVE, " + NULLABLE_ID;
    public static final String UPDATE_MODEL_NULLABLE = "During UPDATE param, " + NULLABLE_MODEL;
    public static final String CREATE_MODEL_NULLABLE = "During CREATE param, " + NULLABLE_MODEL;

}
