package com.keeper.util.validation.impl;

/*
 * Created by @GoodforGod on 12.04.2017.
 */

import com.keeper.util.Validator;
import com.keeper.util.validation.GeoCoordinate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Default Comment
 */
public class GeoCoordinateValidator implements ConstraintValidator<GeoCoordinate, String> {
    @Override
    public void initialize(GeoCoordinate geoCoord) { }

    @Override
    public boolean isValid(String coord, ConstraintValidatorContext constraintValidatorContext) {
        return Validator.isGeoCoordValid(coord);
    }
}
