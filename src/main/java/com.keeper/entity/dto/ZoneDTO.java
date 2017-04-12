package com.keeper.entity.dto;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.keeper.entity.types.UserType;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Default Comment
 */
public class ZoneDTO {

    public static final ZoneDTO EMPTY = new ZoneDTO((long) UserType.EMPTY.getValue());

    private final Long  userId;
    private String      city;
    private String      country;
    private Timestamp   registerDate;

    private ZoneDTO() {
        this.userId         = (long) UserType.UNKNOWN.getValue();
        this.city           = "";
        this.country        = "";
        this.registerDate   = Timestamp.valueOf(LocalDateTime.MIN);
    }

    private ZoneDTO(Long userId) {
        super();
        this.userId = userId;
    }

    public ZoneDTO(Long userId, String city, String country, Timestamp timestamp) {
        this.userId         = (userId == null) ? UserType.EMPTY.getValue() : userId;
        this.city           = city;
        this.country        = country;
        this.registerDate   = timestamp;
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

    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZoneDTO that = (ZoneDTO) o;

        return userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return userId.hashCode();
    }
}
