package com.keeper.model.test;

/**
 * Created by Alexandr Vasiliev on 04.04.2017.
 *
 * @author Alexandr Vasiliev
 */

import com.keeper.model.ModelManager;
import com.keeper.model.states.UserState;
import com.keeper.model.types.UserType;
import com.keeper.util.Converter;
import com.keeper.util.Hasher;
import com.keeper.util.dao.DatabaseResolver;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = DatabaseResolver.TEST_TABLE_USERS, schema = DatabaseResolver.TEST_SCHEMA)
public class UserTest {

    public static final UserTest EMPTY = new UserTest((long)UserType.EMPTY.getValue())
                                                        {{ setType(UserType.EMPTY); }};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)   private Long id;
    @Column(name = "state")                                 private UserState state;
    @Column(name = "type")                                  private UserType type;
    @Column(name = "name",       nullable = false)          private String name;
    @Column(name = "email",      nullable = false)          private String email;
    @Column(name = "maskedEmail",nullable = false)          private String maskedEmail;
    @Column(name = "phone")                                 private String phone;
    @Column(name = "password",   nullable = false)          private String password;
    @Column(name = "about")                                 private String about;
    @Column(name = "isNotified")                            private Boolean isNotified;
    @Column(name = "startMuteTime")                         private Timestamp muteStart;
    @Column(name = "endMuteTime")                           private Timestamp muteEnd;

    private UserTest() {
        this.id         = (long) UserType.UNKNOWN.getValue();
        this.state      = UserState.UNKNOWN;
        this.type       = UserType.UNKNOWN;
        this.name       = "";
        this.email      = "";
        this.maskedEmail= "";
        this.phone      = "";
        this.password   = "";
        this.about      = "";
        this.isNotified = false;
        this.muteStart  = Timestamp.valueOf(LocalDateTime.MIN);
        this.muteEnd    = Timestamp.valueOf(LocalDateTime.MAX);
    }

    private UserTest(Long id) {
        super();
        this.id = id;
    }

    public UserTest(UserType type, String name, String email,
                    String phone, String password, String about) throws NullPointerException {

        if(email == null || email.isEmpty())
            throw new NullPointerException("EMAIL");

        if(password == null || password.isEmpty())
            throw new NullPointerException("PASSWORD");

        if(name == null || name.isEmpty())
            throw new NullPointerException("NAME");

        this.state      = UserState.AWAIT_VERIFICATION;
        this.type       = type != null ? type : UserType.USER;
        this.name       = name;
        this.email      = Hasher.generateHashCrypto(email, Hasher.HashType.EMAIL);
        this.maskedEmail= Converter.maskEmail(email);
        this.phone      = phone;
        this.password   = Hasher.generateHashCrypto(password, Hasher.HashType.PASS);
        this.about      = about;
        this.isNotified = false;
    }

    public static UserTest gen(UserType type, String name, String email,
                               String phone, String password, String about) {
        try {
            return new UserTest(type, name, email, phone, password, about);
        } catch (NullPointerException e) {
            ModelManager.logConstructError("GEN", e);
        }
        return EMPTY;
    }

    // JUST FOR TESTING WITH MAP
    // IN REST CONTROLLER
    public void setId(Long id) {
        this.id = id;
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

    public void setType(UserType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaskedEmail() {
        return maskedEmail;
    }

    public void setMaskedEmail(String maskedEmail) {
        this.maskedEmail = maskedEmail;
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

    public Boolean getNotified() {
        return isNotified;
    }

    public void setNotified(Boolean notified) {
        isNotified = notified;
    }

    public Timestamp getMuteStart() {
        return muteStart;
    }

    public void setMuteStart(Timestamp muteStart) {
        this.muteStart = muteStart;
    }

    public Timestamp getMuteEnd() {
        return muteEnd;
    }

    public void setMuteEnd(Timestamp muteEnd) {
        this.muteEnd = muteEnd;
    }
    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTest userTest = (UserTest) o;

        return email.equals(userTest.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}