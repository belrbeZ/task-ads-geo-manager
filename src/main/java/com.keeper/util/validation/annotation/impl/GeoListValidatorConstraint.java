package com.keeper.util.validation.annotation.impl;

/*
 * Created by @GoodforGod on 16.04.2017.
 */

import com.keeper.util.Validator;
import com.keeper.util.validation.annotation.GeoList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Default Comment
 */
public class GeoListValidatorConstraint implements ConstraintValidator<GeoList, String[]> {

    @Override
    public void initialize(GeoList geo) { }

    @Override
    public boolean isValid(String[] geoList, ConstraintValidatorContext constraintValidatorContext) {
        return Validator.isGeoValid(Arrays.asList(geoList));
    }
}
