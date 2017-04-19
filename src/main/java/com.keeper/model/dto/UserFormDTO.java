package com.keeper.model.dto;

/*
 * Created by @GoodforGod on 19.04.2017.
 */

import com.keeper.model.types.UserType;
import com.keeper.util.validation.Phone;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Default Comment
 */
public class UserFormDTO {
    private UserType type = UserType.UNKNOWN;

    @NotEmpty private String name;
    @Email private String email;
    @Phone private String phone;
    @NotEmpty private String password;
    @NotEmpty private String passwordRepeted;

    //<editor-fold desc="GetterAndSetter">

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

    public String getPasswordRepeted() {
        return passwordRepeted;
    }

    public void setPasswordRepeted(String passwordRepeted) {
        this.passwordRepeted = passwordRepeted;
    }
    //</editor-fold>
}
