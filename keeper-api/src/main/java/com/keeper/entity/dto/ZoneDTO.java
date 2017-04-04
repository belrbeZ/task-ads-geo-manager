package com.keeper.entity.dto;

/*
 * Created by Alexandr Vasiliev on 30.03.2017.
 */

import com.keeper.entity.Zone;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.TimeZone;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * User Current Time Zone and Location
 */
public class ZoneDTO {

    public static ZoneDTO empty = new ZoneDTO();

    private Long userId;
    private String city;
    private String country;
    private Timestamp registerDate = Timestamp.valueOf(LocalDateTime.now());
    private TimeZone timeZone = TimeZone.getDefault();

    private ZoneDTO(){ }

    public ZoneDTO(Long userId, String city, String country) {
        this.userId = userId;
        this.city = city;
        this.country = country;
    }

    public ZoneDTO(Long userId, String city, String country, Timestamp registerDate, TimeZone timeZone) {
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
