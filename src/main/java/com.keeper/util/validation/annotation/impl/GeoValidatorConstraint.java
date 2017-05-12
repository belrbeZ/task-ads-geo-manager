package com.keeper.util.validation.annotation.impl;

/*
 * Created by @GoodforGod on 12.04.2017.
 */

import com.keeper.util.Validator;
import com.keeper.util.validation.annotation.Geo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Default Comment
 */
public class GeoValidatorConstraint implements ConstraintValidator<Geo, String> {
    @Override
    public void initialize(Geo geo) { }

    @Override
    public boolean isValid(String geo, ConstraintValidatorContext constraintValidatorContext) {
        return Validator.isGeoValid(geo);
    }
}
