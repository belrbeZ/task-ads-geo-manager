package com.keeper.entity.dto;

/*
 * Created by @GoodforGod on 4.04.2017.
 */

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.TimeZone;

/**
 * Default Comment
 */
public class ZoneTestDTO {
    public static ZoneTestDTO empty = new ZoneTestDTO();

    private Long userId;
    private String city;
    private String country;
    private Timestamp registerDate = Timestamp.valueOf(LocalDateTime.now());
    private TimeZone timeZone = TimeZone.getDefault();

    private ZoneTestDTO(){ }

    public ZoneTestDTO(Long userId, String city, String country) {
        this.userId = userId;
        this.city = city;
        this.country = country;
    }

    public ZoneTestDTO(Long userId, String city, String country, Timestamp registerDate, TimeZone timeZone) {
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
