package com.keeper.entity.dto;

/*
 * Created by @GoodforGod on 4.04.2017.
 */

import java.sql.Timestamp;

/**
 * Default Comment
 */
public class ZoneTestDTO {
    public static final ZoneTestDTO empty = new ZoneTestDTO();

    private Long userId;
    private String city;
    private String country;
    private Timestamp registerDate;

    private ZoneTestDTO() { }

    public ZoneTestDTO(Long userId, String city, String country, Timestamp timestamp) {
        this.userId = userId;
        this.city = city;
        this.country = country;
        this.registerDate = timestamp;
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

        ZoneTestDTO that = (ZoneTestDTO) o;

        return userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return userId.hashCode();
    }
}
