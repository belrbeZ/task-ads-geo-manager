package com.keeper.util;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.model.dao.*;
import org.springframework.boot.json.GsonJsonParser;

/**
 * Used to convert entities to JSON and other format representation
 */
public class Converter
{
    public static final String emptyJson = "";

    public static String convertToJson(User usr) {
        return emptyJson;
    }

    public static String converToJson(Task task) {
        return emptyJson;
    }

    public static String convertToJson(Route route) {
        return emptyJson;
    }

    public static String convertToJson(GeoPoint point) {
        return emptyJson;
    }
}
