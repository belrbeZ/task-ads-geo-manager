package com.keeper.dto;

/*
 * Created by Alexandr Vasiliev on 30.03.2017.
 */

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.TimeZone;

/**
 * User Current Time Zone and Location
 */
public class ZoneDto {

    public static ZoneDto empty = new ZoneDto();

    private Long ownerId;

    private String city;

    private String country;

    private Timestamp registerDate = Timestamp.valueOf(LocalDateTime.now());

    private TimeZone timeZone = TimeZone.getDefault();

    private ZoneDto(){ }

    public ZoneDto(Long ownerId, String city, String country) {
        this.ownerId = ownerId;
        this.city = city;
        this.country = country;
    }

    public ZoneDto(Long userId, String city, String country, Timestamp registerDate, TimeZone timeZone) {
        this(userId, city, country);
        this.registerDate = registerDate;
        this.timeZone = timeZone;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getOwnerId() {
        return ownerId;
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
