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
    private static final String EMPTY_JSON = "";
    private static final Character MASK_SYMBOL = '*';

    //<editor-fold desc="Masker">

    /**
     * Mask email from like 'bob@mail.ru' to 'b**@***l.ru'
     * @param email email to mask
     * @return masked email
     */
    @Nullable
    public static String maskEmail(String email) {
        return !Validator.isEmailValid(email) ? null : maskStr(email, email.indexOf('@'));
    }

    @Nullable
    public static String maskStr(String str) {
        return maskStr(str, 0);
    }

    @Nullable
    public static String maskStr(String str, int desiredSpreadPoint) {
        return maskStr(str, desiredSpreadPoint, 0);
    }

    @Nullable
    public static String maskStr(String str, int desiredSpreadPoint, int power) {
        return maskStr(str, desiredSpreadPoint, power, power);
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
    public static String maskStr(String str,
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
        if((spreadPoint = desiredSpreadPoint) == 0 || desiredSpreadPoint > length)
            spreadPoint = length / 2;

        // Calculate mask right end position
        int rightBorder = length - spreadPoint;
        int powerRight = (desiredPowerRight == 0 || desiredPowerRight > rightBorder)
                ? rightBorder / 2 - 1
                : desiredPowerRight;

        // Calculate mask left end position
        int leftBoarder = length - rightBorder;
        int powerLeft = (desiredPowerLeft == 0 || desiredPowerLeft > leftBoarder)
                ? leftBoarder / 2 - 1
                : desiredPowerLeft;

        char[] maskRight = new char[powerRight];
        char[] maskLeft = new char[powerLeft];

        Arrays.fill(maskRight, MASK_SYMBOL);
        Arrays.fill(maskLeft, MASK_SYMBOL);

        maskedString.replace(spreadPoint, spreadPoint + powerRight, Arrays.toString(maskRight));
        maskedString.replace(spreadPoint - powerLeft, spreadPoint, Arrays.toString(maskLeft));

        return maskedString.toString();
    }
    //</editor-fold>

    //<editor-fold desc="toDTO">

    public static UserTestDTO convertToDTO(UserTest model) {
        return new UserTestDTO(model.getId(),
                                model.getType(),
                                model.getName(),
                                model.getEmail(),
                                model.getPhone(),
                                model.getAbout(),
                                model.getNotified());
    }

    public static ZoneTestDTO convertToDTO(ZoneTest model) {
        return new ZoneTestDTO(model.getUserId(),
                                model.getCity(),
                                model.getCountry(),
                                model.getRegisterDate());
    }
    //</editor-fold>

    //<editor-fold desc="toJsonTesting">

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

    //<editor-fold desc="toJsonProduction">

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
