package com.keeper.entity;

/*
 * Created by GoodforGod on 20.03.2017.
 */

import java.sql.Timestamp;

/**
 * Sleep Time Notification Period Implementation
 */
public class SleepTime {

    private Integer userId;

    private Boolean isEnabled;
    private Timestamp timeStart;
    private Timestamp timeEnd;

    //<editor-fold desc="GetterAndSetter">

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
