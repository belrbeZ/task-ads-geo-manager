package com.keeper.entity;

/*
 * Created by GoodforGod on 20.03.2017.
 */

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Sleep Time Notification Period Implementation
 */
public class SleepTime {

    public static final SleepTime empty = new SleepTime();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long userId;

    @Column(name = "type", nullable = false)
    private Boolean isEnabled = false;

    @Column(name = "type")
    private Timestamp timeStart;

    @Column(name = "type")
    private Timestamp timeEnd;

    private SleepTime() { }

    public SleepTime(Long userId) {
        this.userId = userId;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getUserId() {
        return userId;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Timestamp getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }

    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
    }
    //</editor-fold>

}
