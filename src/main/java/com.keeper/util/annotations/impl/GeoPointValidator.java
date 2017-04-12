package com.keeper.util.annotations.impl;

/*
 * Created by @GoodforGod on 12.04.2017.
 */

import com.keeper.util.annotations.GeoPoint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Default Comment
 */
public class GeoPointValidator implements ConstraintValidator<GeoPoint, String> {
    @Override
    public void initialize(GeoPoint geoPoint) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
