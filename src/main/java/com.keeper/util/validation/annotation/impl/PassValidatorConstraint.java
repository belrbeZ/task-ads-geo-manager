package com.keeper.util.validation.annotation.impl;

import com.keeper.util.Validator;
import com.keeper.util.validation.annotation.Pass;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 12.05.2017
 */
public class PassValidatorConstraint implements ConstraintValidator<Pass, String> {

        @Override
        public void initialize(Pass phone) { }

        @Override
        public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
                return Validator.isPhoneValid(phone);
        }
}
