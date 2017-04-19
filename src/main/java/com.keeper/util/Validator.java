package com.keeper.util;

/*
 * Created by @GoodforGod on 16.04.2017.
 */

import java.util.List;
import java.util.function.Predicate;

/**
 * Default Comment
 */
public class Validator {

    public static final int EMAIL_INCORRECT = -1;

    public static int isEmailValidReturnIndex(String email) {
        return (email != null && email.length() > 3) ? email.indexOf('@') : EMAIL_INCORRECT;
    }

    public static Predicate<String> phoneFilter = (Validator::isPhoneValid);

    public static boolean isPhoneValid(String phone) {
        return !(phone == null || phone.isEmpty())
                //validate phone numbers of format "1234567890"
                && (phone.matches("\\d{10}")
                //validating phone number with -, . or spaces
                || phone.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")
                //validating phone number with extension length from 3 to 5
                || phone.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")
                //validating phone number where area code is in braces ()
                || phone.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"));

    }

    public static Predicate<String> geoCoordFilter = (Validator::isGeoCoordValid);

    public static boolean isGeoCoordValid(String coord) {
        return coord != null
                && !coord.isEmpty()
                && coord.matches("^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?),\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$");
    }

    public static boolean isGeoCoordValid(List<String> coords) {
        return coords.stream().noneMatch(Validator.geoCoordFilter);
    }
}
