package com.keeper.entity;

/*
 * Created by GoodforGod on 20.03.2017.
 */

import java.sql.Timestamp;
import java.util.TimeZone;

/**
 * User Current Time Zone and Location
 */
public class Zone {

    public static Zone empty = new Zone();

    private Long userId;

    private String city;
    private String country;

    private Timestamp registerDate;
    private TimeZone timeZone;

    private Zone(){ }

    public Zone(Long userId, String city, String country) {
        this.userId = userId;
        this.city = city;
        this.country = country;
    }

    public Zone(Long userId, String city, String country, Timestamp registerDate, TimeZone timeZone) {
        this(userId, city, country);
        this.registerDate = registerDate;
        this.timeZone = timeZone;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getUserId() {
        return userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
    //</editor-fold>

}
