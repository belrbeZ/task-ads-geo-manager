package com.keeper.util.annotations.impl;

/*
 * Created by @GoodforGod on 12.04.2017.
 */

import com.keeper.util.Validator;
import com.keeper.util.annotations.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Default Comment
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public void initialize(Phone phone) { }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        return Validator.isPhoneValid(phone);
    }
}
