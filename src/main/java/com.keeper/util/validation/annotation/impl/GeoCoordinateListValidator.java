package com.keeper.util.validation.annotation.impl;

/*
 * Created by @GoodforGod on 16.04.2017.
 */

import com.keeper.util.Validator;
import com.keeper.util.validation.annotation.GeoCoordinateList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Default Comment
 */
public class GeoCoordinateListValidator implements ConstraintValidator<GeoCoordinateList, List<String>> {

    @Override
    public void initialize(GeoCoordinateList geoCoord) { }

    @Override
    public boolean isValid(List<String> coords, ConstraintValidatorContext constraintValidatorContext) {
        return Validator.isGeoCoordValid(coords);
    }
}
