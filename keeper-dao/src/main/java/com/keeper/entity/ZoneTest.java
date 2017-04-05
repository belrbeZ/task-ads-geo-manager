package com.keeper.entity;

/*
 * Created by @GoodforGod on 4.04.2017.
 */

import com.keeper.util.DatabaseResolver;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.TimeZone;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Default Comment
 */
@Entity
@Table(name = DatabaseResolver.TEST_TABLE_ZONES, schema = DatabaseResolver.TEST_SCHEMA)
public class ZoneTest {

    public static ZoneTest empty = new ZoneTest();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "userId", unique = true, nullable = false)   private Long userId;
    @Column(name = "city")                                      private String city;
    @Column(name = "country", nullable = false)                 private String country;
    @Column(name = "registerDate", nullable = false)            private Timestamp registerDate = Timestamp.valueOf(LocalDateTime.now());
//    @Column(name = "timeZone", nullable = false)                private TimeZone timeZone = TimeZone.getDefault();

    private ZoneTest(){ }

    public ZoneTest(Long userId, String city, String country) {
        this.userId = userId;
        this.city = city;
        this.country = country;
    }

    public ZoneTest(Long userId, String city, String country, Timestamp registerDate){//}, TimeZone timeZone) {
        this(userId, city, country);
        this.registerDate = registerDate;
//        this.timeZone = timeZone;
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

//    public TimeZone getTimeZone() {
//        return timeZone;
//    }
//
//    public void setTimeZone(TimeZone timeZone) {
//        this.timeZone = timeZone;
//    }
    //</editor-fold>
}
