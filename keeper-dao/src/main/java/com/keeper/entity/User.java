package com.keeper.entity;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.states.UserState;
import com.keeper.states.UserType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * User model implementation
 */
@Entity
@Table(name = "Users", schema = "entities")
public class User implements IModel<Long>{

    public static final User empty = new User();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "state", nullable = false)
    private UserState state = UserState.AWAIT_VERIFICATION;

    @Column(name = "type", nullable = false)
    private UserType type;

    @NotEmpty
    @Column(name = "firstName", nullable = false)
    private String FirstName;

    @NotEmpty
    @Column(name = "lastName", nullable = false)
    private String LastName;

    @NotEmpty
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @NotEmpty
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "about")
    private String about;

    @Column(name = "zone")
    private Long zoneId;

    // Retrieved from DB via Query
    private Zone zone;

    @Column(name = "type", nullable = false)
    private Boolean isEnabled = false;

    @Column(name = "type")
    private Timestamp timeStart;

    @Column(name = "type")
    private Timestamp timeEnd;

    private User() { }

    private User(UserType type, String fName, String lName, String password, String about, Zone zone) {
        this.type = type;
        this.FirstName = fName;
        this.LastName = lName;
        this.password = password;
        this.about = about;

        this.zone = zone;
    }

    public User(UserType type, String fName, String lName, String email, String password, String about, Zone zone) {
        this(type, fName,lName, password, about, zone);
        this.email = email;
    }

    public User(UserType type, String fName, String lName, String email, String phone, String password, String about, Zone zone) {
        this(type, fName,lName, email, password, about, zone);
        this.phone = phone;
    }

    //<editor-fold desc="GetterAndSetter">

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

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
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

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
