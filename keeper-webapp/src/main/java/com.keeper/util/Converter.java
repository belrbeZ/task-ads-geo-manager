package com.keeper.util;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.entity.dao.UserTest;
import com.keeper.entity.dao.ZoneTest;
import com.keeper.entity.dto.UserTestDTO;
import com.keeper.entity.dto.ZoneTestDTO;

/**
 * Used to convert entities to JSON and other format representation
 */
public class Converter
{
    public static final String emptyJson = "";

    //<editor-fold desc="Testing">

    public static String convertToJson(UserTest model) {
        return null;
    }

    public static String convertToJson(UserTestDTO model) {
        return null;
    }

    public static String convertToJson(ZoneTest model) {
        return null;
    }

    public static String convertToJson(ZoneTestDTO model) {
        return null;
    }
    //</editor-fold>

    //<editor-fold desc="Production">

/*    public static String convertToJson(UserDTO model) {

        return emptyJson;
    }

    public static String convertToJson(ZoneDTO model) {
        return emptyJson;
    }

    public static String converToJson(TaskDTO task) {

        return emptyJson;
    }

    public static String convertToJson(RouteDTO route) {

        return emptyJson;
    }

    public static String convertToJson(GeoPointDTO coord) {

        return emptyJson;
    }*/
    //</editor-fold>
}
