package com.keeper.dto;

import com.keeper.entity.states.UserState;
import com.keeper.entity.states.UserType;

import java.sql.Timestamp;

/**
 * Created by Alexandr Vasiliev on 29.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */
public class UserDto implements ModelDto<Long> {

    public static final UserDto empty = new UserDto();

    private Long id;

    private UserState state = UserState.AWAIT_VERIFICATION;

    private UserType type;

    private String FirstName;

    private String LastName;

    private String email;

    private String phone;

    private String password;

    private String about;

    private Long zoneId;

    // Retrieved from DB via Query
    private ZoneDto zone;

    private Boolean isEnabled = false;

    private Timestamp timeStart;

    private Timestamp timeEnd;

    public UserDto() { }

    public UserDto(UserType type, String fName, String lName, String password, String about, ZoneDto zone) {
        this.type = type;
        this.FirstName = fName;
        this.LastName = lName;
        this.password = password;
        this.about = about;

        this.zone = zone;
    }

    public UserDto(UserType type, String fName, String lName, String email, String password, String about, ZoneDto zone) {
        this(type, fName,lName, password, about, zone);
        this.email = email;
    }

    public UserDto(UserType type, String fName, String lName, String email, String phone, String password, String about, ZoneDto zone) {
        this(type, fName,lName, email, password, about, zone);
        this.phone = phone;
    }

    //<editor-fold desc="GetterAndSetter">


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public UserType getType() {
        return type;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public ZoneDto getZone() {
        return zone;
    }

    public void setZone(ZoneDto zone) {
        this.zone = zone;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto user = (UserDto) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
