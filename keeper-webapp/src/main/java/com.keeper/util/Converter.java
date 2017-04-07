package com.keeper.util;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.entity.dao.UserTest;
import com.keeper.entity.dao.ZoneTest;
import com.keeper.entity.dto.UserTestDTO;
import com.keeper.entity.dto.ZoneTestDTO;
import com.sun.istack.internal.Nullable;

import java.util.Arrays;

/**
 * Used to convert entities to JSON and other format representation
 */
public class Converter
{
    public static final String EMPTY_JSON = "";
    public static final Character MASK_SYMBOL = '*';

    //<editor-fold desc="Masker">

    /**
     * Mask email from like 'bob@mail.ru' to 'b**@***l.ru'
     * @param email email to mask
     * @return masked email
     */
    @Nullable
    public static String convertToMaskEmail(String email) {
        return !Validator.isEmailValid(email) ? null : convertToMaskStr(email, email.indexOf('@'));
    }

    @Nullable
    public static String convertToMaskStr(String str) {
        return convertToMaskStr(str, 0);
    }

    @Nullable
    public static String convertToMaskStr(String str, int desiredSpreadPoint) {
        return convertToMaskStr(str, desiredSpreadPoint, 0);
    }

    @Nullable
    public static String convertToMaskStr(String str, int desiredSpreadPoint, int power) {
        return convertToMaskStr(str, desiredSpreadPoint, power, power);
    }

    /**
     * Convert ordinary string like 'hello' to masked one like 'he**o'
     * @param str string to mask
     * @param desiredSpreadPoint center point from where start masking
     * @param desiredPowerLeft power to mask left side
     * @param desiredPowerRight power to mask right side
     * @return masked string
     */
    @Nullable
    public static String convertToMaskStr(String str,
                                          int desiredSpreadPoint,
                                          int desiredPowerLeft,
                                          int desiredPowerRight) {

        StringBuilder maskedString = new StringBuilder(str);
        int length, spreadPoint;

        if(str == null || (length = str.length()) == 0)
            return null;

        switch (length) {
            case 1:
                return MASK_SYMBOL.toString();

            case 2:
                char[] arr = str.toCharArray();
                arr[0] = MASK_SYMBOL;
                return Arrays.toString(arr);

            default: break;
        }

        // In case desiredSpreadPoint is too big or 0
        if((spreadPoint = desiredSpreadPoint) == 0 || desiredSpreadPoint > str.length())
            spreadPoint = length / 2;

        // Calculate mask right end position
        int rightBorder = length - spreadPoint;
        if(desiredPowerRight == 0 || desiredPowerRight > rightBorder)
            desiredPowerRight = rightBorder / 2 - 1;

        // Calculate mask left end position
        int leftBoarder = length - rightBorder;
        if(desiredPowerLeft == 0 || desiredPowerLeft > leftBoarder)
            desiredPowerLeft = leftBoarder / 2 - 1;

        char[] maskRight = new char[desiredPowerRight];
        char[] maskLeft = new char[desiredPowerLeft];

        Arrays.fill(maskRight, MASK_SYMBOL);
        Arrays.fill(maskLeft, MASK_SYMBOL);

        maskedString.replace(spreadPoint, spreadPoint + desiredPowerRight, Arrays.toString(maskRight));
        maskedString.replace(spreadPoint - desiredPowerLeft, spreadPoint, Arrays.toString(maskLeft));


        return maskedString.toString();
    }
    //</editor-fold>


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

        return EMPTY_JSON;
    }

    public static String convertToJson(ZoneDTO model) {
        return EMPTY_JSON;
    }

    public static String converToJson(TaskDTO task) {

        return EMPTY_JSON;
    }

    public static String convertToJson(RouteDTO route) {

        return EMPTY_JSON;
    }

    public static String convertToJson(GeoPointDTO coord) {

        return EMPTY_JSON;
    }*/
    //</editor-fold>
}
